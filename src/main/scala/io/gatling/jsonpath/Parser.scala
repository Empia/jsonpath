package io.gatling.jsonpath

import scala.util.parsing.combinator._
import io.gatling.jsonpath.AST._

object Parser extends RegexParsers {

	def compile(jsonpath: String): ParseResult[List[PathToken]] = {
		parse(query, jsonpath)
	}

	/// general purpose parsers ///////////////////////////////////////////////

	val number: Parser[Int] = """-?\d+""".r ^^ (_.toInt)

	val field: Parser[String] = """[$_\p{L}][$_\-\d\p{L}]*""".r

	val quotedField: Parser[String] = "'" ~> "[^']+".r <~ "'"

	/// array parsers /////////////////////////////////////////////////////////

	val arraySliceStep: Parser[Option[Int]] = ":" ~> number.?

	val arraySlice: Parser[ArraySlice] =
		(":" ~> number.?) ~ arraySliceStep.? ^^ {
			case end ~ step => ArraySlice(None, end, step.flatten.getOrElse(1))
		}

	val arrayRandomAccess: Parser[Option[ArrayRandomAccess]] =
		rep("," ~> number).? ^^ (indices => indices.map(ArrayRandomAccess(_)))

	val arrayPartial: Parser[ArrayAccessor] =
		number ~ (arraySlice | arrayRandomAccess) ^^ {
			case i ~ None => ArrayRandomAccess(i :: Nil)
			case i ~ Some(ArrayRandomAccess(indices)) => ArrayRandomAccess(i :: indices)
			case i ~ (as @ ArraySlice(_, _, _)) => as.copy(start = Some(i))
		}

	val arrayAll: Parser[ArraySlice] =
		"*" ^^ (_ => ArraySlice(None, None))

	val arrayAccessors: Parser[ArrayAccessor] =
		"[" ~> (arrayAll | arrayPartial | arraySlice) <~ "]"

	/// filters parsers ///////////////////////////////////////////////////////

	val numberValue: Parser[JPNumber] = """-?\d+(\.\d*)?""".r ^^ {
		s => if (s.contains(".")) JPDouble(s.toDouble) else JPLong(s.toLong)
	}
	val stringValue: Parser[JPString] = quotedField ^^ { JPString(_) }
	val valueToken: Parser[FilterToken] = (numberValue | stringValue)

	// TODO do that in a single regex instead ?
	val binaryOperation: Parser[String] = "==|<=|>=|<|>".r

	val current: Parser[PathToken] = "@" ^^ (_ => currentObject)

	lazy val subQuery: Parser[SubQuery] =
		current ~ pathSequence ^^ { case c ~ ps => SubQuery(c :: ps) }

	lazy val filter1: Parser[PathToken] =
		subQuery ~ (binaryOperation ~ (subQuery | valueToken)).? ^^ {
			case subq1 ~ None => HasFilter(subq1)
			case lhs ~ Some(op ~ rhs) => BinaryOpFilter(op, lhs, rhs)
		}

	lazy val filter2: Parser[PathToken] =
		valueToken ~ binaryOperation ~ (subQuery | valueToken) ^^ {
			case lhs ~ op ~ rhs => BinaryOpFilter(op, lhs, rhs)
		}

	lazy val subscriptFilter: Parser[PathToken] =
		"[?(" ~> (filter1 | filter2) <~ ")]"

	/// child accessors parsers ///////////////////////////////////////////////

	val subscriptField: Parser[FieldAccessor] =
		"[" ~> repsep(quotedField, ",") <~ "]" ^^ {
			case f1 :: Nil => Field(f1, false)
			case fields => MultiField(fields)
		}

	val dotField: Parser[FieldAccessor] =
		"." ~> field ^^ (Field(_, false))

	// TODO recursive with `subscriptField`
	val recursiveField: Parser[FieldAccessor] =
		".." ~> field ^^ (Field(_, true))

	val anyChild: Parser[FieldAccessor] = (".*" | "['*']") ^^ (_ => anyField)

	val anyRecursive: Parser[FieldAccessor] = "..*" ^^ (_ => anyRecursiveField)

	lazy val fieldAccessors = (
		dotField
		| anyRecursive
		| anyChild
		| recursiveField
		| subscriptField)

	/// Main parsers //////////////////////////////////////////////////////////

	lazy val childAccess = (fieldAccessors | arrayAccessors)

	lazy val pathSequence: Parser[List[PathToken]] = rep(childAccess | subscriptFilter)

	val root: Parser[PathToken] = "$" ^^ (_ => rootObject)

	lazy val query: Parser[List[PathToken]] =
		phrase(root ~ pathSequence) ^^ { case r ~ ps => r :: ps }

}