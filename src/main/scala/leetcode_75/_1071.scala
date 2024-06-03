package leetcode_75

object _1071 {

  def gcdOfStringsV1(str1: String, str2: String): String =
    (str1, str2) match {
      case (x, y) if x == y              => x
      case (x, y) if x.length > y.length => gcdOfStringsV1(y, x)
      case (x, y) if y.startsWith(x)     => gcdOfStringsV1(y.substring(x.length), x)
      case _                             => ""
    }

  def gcdOfStrings(str1: String, str2: String): String = {
    val s1Len                   = str1.length
    val s2Len                   = str2.length
    val (shorterStr, longerStr) = if (s1Len < s2Len) (str1, str2) else (str2, str1)
    val shorterLen              = shorterStr.length
    val longerLen               = longerStr.length
    var flag                    = false
    val possibleDevisors = for {
      i <- shorterLen until 0 by -1
      if shorterLen % i == 0
      if !flag
      numOfCharactor = i
      longerTimes    = longerLen / numOfCharactor
      if longerLen % numOfCharactor == 0
      shorterTimes = shorterLen / numOfCharactor
      subStr       = shorterStr.substring(0, numOfCharactor)
      if subStr * shorterTimes == shorterStr
      if subStr * longerTimes == longerStr
      flag = true
    } yield subStr
    possibleDevisors.headOption.getOrElse("")
  }

  def main(args: Array[String]): Unit =
    println(gcdOfStrings("ABABABAB", "ABAB"))

}
