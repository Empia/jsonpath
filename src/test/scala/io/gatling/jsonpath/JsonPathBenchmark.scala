/**
 * Copyright 2011-2013 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.jsonpath;

import org.scalameter.api.{Gen, PerformanceTest}

import com.fasterxml.jackson.databind.ObjectMapper

object JsonPathBenchmark extends PerformanceTest.Quickbenchmark {

	val mapper = new ObjectMapper

	val twitterJson = mapper.readValue("""{"completed_in":0.072,"max_id":336448826225328128,"max_id_str":"336448826225328128","next_page":"?page=2&max_id=336448826225328128&q=gatling","page":1,"query":"gatling","refresh_url":"?since_id=336448826225328128&q=gatling","results":[{"created_at":"Mon, 20 May 2013 11:50:25 +0000","from_user":"anna_gatling","from_user_id":1237619628,"from_user_id_str":"1237619628","from_user_name":"Anna Gatling","geo":null,"id":336448826225328128,"id_str":"336448826225328128","iso_language_code":"en","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3402698946\/bebb3fcb7a7a3977a69c30797cfce5db_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3402698946\/bebb3fcb7a7a3977a69c30797cfce5db_normal.jpeg","source":"&lt;a href=&quot;http:\/\/twitter.com\/download\/iphone&quot;&gt;Twitter for iPhone&lt;\/a&gt;","text":"Last Monday of 6th grade yayyyyy"},{"created_at":"Mon, 20 May 2013 11:49:40 +0000","from_user":"ddnn_","from_user_id":482530993,"from_user_id_str":"482530993","from_user_name":"D'\u306e\u7d14\u60c5","geo":null,"id":336448635355144192,"id_str":"336448635355144192","iso_language_code":"tl","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3676715268\/74fa7666ffce02296cc7dfa25f6a8f9c_normal.png","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3676715268\/74fa7666ffce02296cc7dfa25f6a8f9c_normal.png","source":"&lt;a href=&quot;http:\/\/m.ubersocial.com&quot;&gt;UberSocial Mobile&lt;\/a&gt;","text":"@Arc46_ gatling gun... as in minigun or what?","to_user":"Arc46_","to_user_id":336528266,"to_user_id_str":"336528266","to_user_name":"SamuelJunioPradipta","in_reply_to_status_id":336448069233172480,"in_reply_to_status_id_str":"336448069233172480"},{"created_at":"Mon, 20 May 2013 11:48:56 +0000","from_user":"FonshudelSur","from_user_id":300933633,"from_user_id_str":"300933633","from_user_name":"Fonshu","geo":null,"id":336448452076634113,"id_str":"336448452076634113","iso_language_code":"es","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3654066775\/8da1e0e3f2d9ef89f34ac66993bb8836_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3654066775\/8da1e0e3f2d9ef89f34ac66993bb8836_normal.jpeg","source":"&lt;a href=&quot;http:\/\/www.tweetdeck.com&quot;&gt;TweetDeck&lt;\/a&gt;","text":"@IsaraMiau Y tengo que currarme un cosplay para ir del patriota mecanizado con la gatling steampunk, que es DE LO MEJOR &lt;3","to_user":"FonshudelSur","to_user_id":300933633,"to_user_id_str":"300933633","to_user_name":"Fonshu","in_reply_to_status_id":336448304835608576,"in_reply_to_status_id_str":"336448304835608576"},{"created_at":"Mon, 20 May 2013 11:47:25 +0000","from_user":"Arc46_","from_user_id":336528266,"from_user_id_str":"336528266","from_user_name":"SamuelJunioPradipta","geo":null,"id":336448069233172480,"id_str":"336448069233172480","iso_language_code":"en","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3684084503\/2e880c5f9b9d7d6030d6d972feb9f5c4_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3684084503\/2e880c5f9b9d7d6030d6d972feb9f5c4_normal.jpeg","source":"&lt;a href=&quot;http:\/\/www.tweetdeck.com&quot;&gt;TweetDeck&lt;\/a&gt;","text":"Something like Gatling gun, Bazooka RT @ddnn_: what are you exactly trying to make?"},{"created_at":"Mon, 20 May 2013 11:37:49 +0000","from_user":"anna_gatling","from_user_id":1237619628,"from_user_id_str":"1237619628","from_user_name":"Anna Gatling","geo":null,"id":336445653662191616,"id_str":"336445653662191616","iso_language_code":"en","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3402698946\/bebb3fcb7a7a3977a69c30797cfce5db_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3402698946\/bebb3fcb7a7a3977a69c30797cfce5db_normal.jpeg","source":"&lt;a href=&quot;http:\/\/twitter.com\/download\/iphone&quot;&gt;Twitter for iPhone&lt;\/a&gt;","text":"Mondays&lt;"},{"created_at":"Mon, 20 May 2013 11:29:57 +0000","from_user":"GATLING_FIGHTER","from_user_id":1184500015,"from_user_id_str":"1184500015","from_user_name":"M134 \u307f\u306b-\u304c\u3093","geo":null,"id":336443676270157826,"id_str":"336443676270157826","iso_language_code":"ja","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3607829622\/68059740f01d6532bc876e2e7ffb84d0_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3607829622\/68059740f01d6532bc876e2e7ffb84d0_normal.jpeg","source":"&lt;a href=&quot;http:\/\/theworld09.com\/&quot;&gt;TheWorld\u2800&lt;\/a&gt;","text":"@Orz619 \u4f55\u3067\u3059\u3063\u3066\uff01\uff1f","to_user":"Orz619","to_user_id":1393895851,"to_user_id_str":"1393895851","to_user_name":"\u3050\u3063\u3055\u3093@\u9ed2\u732b\u306f\u53f7\u54ed\u3057\u3066\u3044\u307e\u3059\u3088\u3002","in_reply_to_status_id":336443439870779394,"in_reply_to_status_id_str":"336443439870779394"},{"created_at":"Mon, 20 May 2013 11:29:48 +0000","from_user":"GATLING_FIGHTER","from_user_id":1184500015,"from_user_id_str":"1184500015","from_user_name":"M134 \u307f\u306b-\u304c\u3093","geo":null,"id":336443634872360960,"id_str":"336443634872360960","iso_language_code":"ja","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3607829622\/68059740f01d6532bc876e2e7ffb84d0_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3607829622\/68059740f01d6532bc876e2e7ffb84d0_normal.jpeg","source":"&lt;a href=&quot;http:\/\/theworld09.com\/&quot;&gt;TheWorld\u2800&lt;\/a&gt;","text":"RT @Orz619: \u307b\u3093\u304d\u3067\u30b9\u30d1\u30d6\u30ed\u3057\u3088\u3046\u304b\u3068\u691c\u8a0e\u4e2dw"},{"created_at":"Mon, 20 May 2013 10:46:41 +0000","from_user":"Gatling_gun_k","from_user_id":1126180920,"from_user_id_str":"1126180920","from_user_name":"\uac1c\ud2c0\ub9c1 \uae30\uad00\ucd1d","geo":null,"id":336432787248787456,"id_str":"336432787248787456","iso_language_code":"ko","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3171674022\/d318e014542845396c11662986b4285d_normal.png","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3171674022\/d318e014542845396c11662986b4285d_normal.png","source":"&lt;a href=&quot;http:\/\/twittbot.net\/&quot;&gt;twittbot.net&lt;\/a&gt;","text":"\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0\ud0c0!!"},{"created_at":"Mon, 20 May 2013 10:22:40 +0000","from_user":"slam_gatling","from_user_id":1316243516,"from_user_id_str":"1316243516","from_user_name":"SxOxE","geo":null,"id":336426741893578754,"id_str":"336426741893578754","iso_language_code":"ja","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3606289395\/106dee12ccd2fb0bca99ba4b85304d54_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3606289395\/106dee12ccd2fb0bca99ba4b85304d54_normal.jpeg","source":"&lt;a href=&quot;http:\/\/twitter.com\/&quot;&gt;web&lt;\/a&gt;","text":"\u59b9\u304cHUNTER\u00d7HUNTER\u3092\u8aad\u3093\u3067\u308b\u305b\u3044\u304b\u3001\u4ffa\u3082\u4e2d\u5b66\u4ee5\u6765\u4e45\u3005\u306b\u30cf\u30de\u3063\u305f\u3002\u6697\u9ed2\u5927\u9678\u7de8\u304c\u3069\u3046\u306a\u308b\u304b\u6c17\u306b\u306a\u308b\u3051\u3069\u3001\u5927\u66ae\u7dad\u4eba\u307f\u305f\u3044\u306b\u8a71\u3092\u30c7\u30ab\u304f\u3057\u3059\u304e\u3066\u53ce\u96c6\u3064\u304b\u306a\u304f\u306a\u308b\u53ef\u80fd\u6027\u3082\u5fae\u30ec\u5b58\u3002\u3042\u3068\u30af\u30e9\u30d4\u30ab\u304c\u4eca\u5f8c\u3069\u3046\u95a2\u308f\u3063\u3066\u304f\u308b\u306e\u304b\u3082\u6c17\u306b\u306a\u308b\u3068\u3053\u308d\u3002"},{"created_at":"Mon, 20 May 2013 09:46:45 +0000","from_user":"Gatling_gun_k","from_user_id":1126180920,"from_user_id_str":"1126180920","from_user_name":"\uac1c\ud2c0\ub9c1 \uae30\uad00\ucd1d","geo":null,"id":336417701356507136,"id_str":"336417701356507136","iso_language_code":"ko","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3171674022\/d318e014542845396c11662986b4285d_normal.png","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3171674022\/d318e014542845396c11662986b4285d_normal.png","source":"&lt;a href=&quot;http:\/\/twittbot.net\/&quot;&gt;twittbot.net&lt;\/a&gt;","text":"\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c\ud22c!!"},{"created_at":"Mon, 20 May 2013 09:17:47 +0000","from_user":"Gatling_gun_k","from_user_id":1126180920,"from_user_id_str":"1126180920","from_user_name":"\uac1c\ud2c0\ub9c1 \uae30\uad00\ucd1d","geo":null,"id":336410413707169792,"id_str":"336410413707169792","iso_language_code":"ko","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3171674022\/d318e014542845396c11662986b4285d_normal.png","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3171674022\/d318e014542845396c11662986b4285d_normal.png","source":"&lt;a href=&quot;http:\/\/twittbot.net\/&quot;&gt;twittbot.net&lt;\/a&gt;","text":"\ub69c\ub450\ub450\ub450\ub457\ub450\ub450\ub450\ub450\ub450\ub450\ub450\ub450\ub450\ub450!!"},{"created_at":"Mon, 20 May 2013 09:03:00 +0000","from_user":"Rebelzonderrede","from_user_id":983435376,"from_user_id_str":"983435376","from_user_name":"Rebel South","geo":null,"id":336406693384708096,"id_str":"336406693384708096","iso_language_code":"nl","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/2920503711\/6db32e22de8ee8efa92ba1e16ef341b6_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/2920503711\/6db32e22de8ee8efa92ba1e16ef341b6_normal.jpeg","source":"&lt;a href=&quot;http:\/\/www.tweetdeck.com&quot;&gt;TweetDeck&lt;\/a&gt;","text":"20-5-1874: Sterfdag Alexander B. Dyer, Gen vd Unie. 1e Generaal die aanschaf Gatling gun nastreefde #amerikaanseburgeroorlog"},{"created_at":"Mon, 20 May 2013 08:45:00 +0000","from_user":"MahdayMayday","from_user_id":896598301,"from_user_id_str":"896598301","from_user_name":"C H E ' N G A P !","geo":null,"id":336402162995310592,"id_str":"336402162995310592","iso_language_code":"in","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/3089084467\/b5406e2a17e115108d798220ef872e59_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/3089084467\/b5406e2a17e115108d798220ef872e59_normal.jpeg","source":"&lt;a href=&quot;http:\/\/twitter.com\/&quot;&gt;web&lt;\/a&gt;","text":"RT @mnhfz92: @MahdayMayday ah ye..bg Gomu Gomu no Elephant Gatling kang","in_reply_to_status_id":336401088506900480,"in_reply_to_status_id_str":"336401088506900480"},{"created_at":"Mon, 20 May 2013 08:43:55 +0000","from_user":"mnhfz92","from_user_id":282901250,"from_user_id_str":"282901250","from_user_name":"Nor Hafiz","geo":null,"id":336401891959402496,"id_str":"336401891959402496","iso_language_code":"in","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/2661900827\/f41fc3f51c58daac67f1aa481de43819_normal.jpeg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/2661900827\/f41fc3f51c58daac67f1aa481de43819_normal.jpeg","source":"&lt;a href=&quot;http:\/\/twitter.com\/&quot;&gt;web&lt;\/a&gt;","text":"@MahdayMayday ah ye..bg Gomu Gomu no Elephant Gatling kang","to_user":"MahdayMayday","to_user_id":896598301,"to_user_id_str":"896598301","to_user_name":"C H E ' N G A P !","in_reply_to_status_id":336401088506900480,"in_reply_to_status_id_str":"336401088506900480"},{"created_at":"Mon, 20 May 2013 08:00:00 +0000","from_user":"origichara_bot","from_user_id":410573195,"from_user_id_str":"410573195","from_user_name":"\u307f\u3093\u306a\u306e\u30aa\u30ea\u30ad\u30e3\u30e9\u7d39\u4ecbbot","geo":null,"id":336390837846020096,"id_str":"336390837846020096","iso_language_code":"ja","metadata":{"result_type":"recent"},"profile_image_url":"http:\/\/a0.twimg.com\/profile_images\/1634960810\/_____bot_normal.jpg","profile_image_url_https":"https:\/\/si0.twimg.com\/profile_images\/1634960810\/_____bot_normal.jpg","source":"&lt;a href=&quot;http:\/\/twittbot.net\/&quot;&gt;twittbot.net&lt;\/a&gt;","text":"\u300c\u6551\u4e16\u4e3b(\u30e1\u30b7\u30a2)\u3068\u3088\u3079\u3001\u3044\u3044\u306a\uff1f\u300d\u300c\u9ed9\u308c\u5909\u614b\u5909\u4eba\u30b1\u30df\u30ab\u30eb\u30d6\u30ec\u30a4\u30f3\u5973\u304c\u3002\u79c1\u3060\u3063\u3066\u5143\u306f\u4eba\u9593\u3060\u300d\uff0f\u516b\u30f6\u5cf0\u81e8\u592a\u90ce\uff08\u7537\uff6515\u6b73\u30fb\u81ea\u79f0\u6551\u4e16\u4e3b\u306e\u4e2d\u4e8c\u75c5\u30cf\u30a4\u30ab\u30e9\u5c11\u5e74\uff09http:\/\/t.co\/FS7av2d077"}],"results_per_page":15,"since_id":0,"since_id_str":"0"}""", classOf[Object])

	val twitterQueries = Gen.enumeration("twitterQueries")(
		"$.completed_in",
		"$.results[:3].from_user",
		"$.results[1:9:-2].from_user",
		"$.results[*].to_user_name",
		"$.results[5].metadata.result_type",
		"$.results[?(@.from_user == 'anna_gatling')]",
		"$.results[?(@.from_user_id >= 1126180920)]")

	val goessnerJson = mapper.readValue("""
		{ "store": {
		    "book": [ 
		      { "category": "reference",
		        "author": "Nigel Rees",
		        "title": "Sayings of the Century",
		        "price": 8.95
		      },
		      { "category": "fiction",
		        "author": "Evelyn Waugh",
		        "title": "Sword of Honour",
		        "price": 12.99
		      },
		      { "category": "fiction",
		        "author": "Herman Melville",
		        "title": "Moby Dick",
		        "isbn": "0-553-21311-3",
		        "price": 8.99
		      },
		      { "category": "fiction",
		        "author": "J. R. R. Tolkien",
		        "title": "The Lord of the Rings",
		        "isbn": "0-395-19395-8",
		        "price": 22.99
		      }
		    ],
		    "bicycle": {
		      "color": "red",
		      "price": 19.95
		    }
		  }
		}
""", classOf[Object])

	val goessnerQueries = Gen.enumeration("goessnerQueries")(
		"$.store.book[*].author",
		"$..author",
		"$.store.*",
		"$.store..price",
		"$..book[2].title",
		"$..book[-1:].title",
		"$..book[:2].title",
		"$..*",
		"$.store.book[*].niçôlàs['nico']['foo'][*].bar[1:-2:3]",
		"$.store['book'][:2].title",
		"$.store.book[?(@.isbn)].title",
		"$.store.book[?(@.category == 'fiction')].title",
		"$.store.book[?(@.price < 10 && @.price >4)].title")

	performance of "Gatling JsonPath" in {

		measure method "pre-compiled query resolving" in {
			using(goessnerQueries.map(JsonPath.compile(_))) in {
				q => q.right.map(_.query(goessnerJson)).right.map(_.toVector)
			}
			using(twitterQueries.map(JsonPath.compile(_))) in {
				q => q.right.map(_.query(twitterJson)).right.map(_.toVector)
			}
		}
	}
}
