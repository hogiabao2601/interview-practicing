package leetcode_75

object _345 {

  def main(args: Array[String]): Unit = {

    " Hello work   "

//    val s           = "hello".
//    val orign       = Array(1, 2, 3, 4, 5, 6, 7)
//    val vowels      = Array('a', 'e', 'i', 'o', 'u')
//    val vowelsIndex = Array(3, 4, 6, 7)
//
//    val sb = new StringBuilder(s)
//    sb.setCharAt(0, 'x')
//    println(sb.toString)

//    s match {
//      case "hello" => println("world")
//      case _ => println("no")
//    }
  }

  def swapChars(charArray: Array[Char], index1: Int, index2: Int): Array[Char] = {
    val temp = charArray(index1)
    charArray(index1) = charArray(index2)
    charArray(index2) = temp
    charArray
  }

  def reverseVowels(s: String): String = {
    var stringArr: Array[Char] = s.toCharArray
    val vowels: Array[Char] = Array('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    var i = 0
    var j = s.length - 1
    while (i < j) {
      if (vowels.contains(stringArr(i)) && vowels.contains(stringArr(j))) {
        stringArr = swapChars(stringArr, i, j)
        i += 1
        j -= 1
      } else if (vowels.contains(stringArr(i))) {
        j -= 1
      } else if (vowels.contains(stringArr(j))) {
        i += 1
      } else {
        i += 1
        j -= 1
      }
    }
    new String(stringArr)
  }

}
