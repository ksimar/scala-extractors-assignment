
class RegularExpression {

  val EMAIL = """^([a-zA-Z]+[0-9]*[!_-]*)@([a-z]+[\\.][a-z]+[\\.]?[a-z]+)""".r //only !_- are allowed as special symbols

  def findAll(array: Array[String], list: List[String]) = {
    for (arr <- array; s <- EMAIL findAllIn (arr)) yield {
      s :: list
    }
  }

}

object RegularExpression {

  def main(args: Array[String]) = {

    val regExp = new RegularExpression
    println("Part 1\n")
    val str3 = "simarpreet@knoldus.in"
    val str4 = "simarpreet!@knoldusin"
    val str5 = "simarpreet-!@knoldus.in"
    val str6 = "simarpreet@google.co.in"
    val str7 = "simarpreet!@knoldus.in"
    val str8 = "simar02@google.com"

    //invalid emails
    val str1 = "simarpreet!"
    val str2 = "!helo"
    val str9 = "02Simar@google.com"
    val str12 = "simarrrrrrrrr@goooooooooogle.com123"
    //val str13 = "simarrrrrrrrr@goooooooooogle.com.innnnnnnnnnnnnnnnnnnnnnnn"
    val array = Array(str1, str2, str1, str4, str5, str6, str7, str8, str9, str12)

    /* for(arr <- array)yield {
       for (s <- regExp.EMAIL findAllIn (arr))
         println(s)
     }
     println()
     */
    val res = regExp.findAll(array, List())
    println("Matched Email Ids are : ")
    res.foreach(println)

    val regExp.EMAIL(user, domain) = "simarpreet@knoldus.in"
    println("\nPart 2\n")
    println("user = " + user + "\ndomain = " + domain)
  }
}
