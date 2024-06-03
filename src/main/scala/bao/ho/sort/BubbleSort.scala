package bao.ho.sort

object BubbleSort {

//  https://www.youtube.com/watch?v=xli_FI7CuzA
  def bubbleSort(nums: Array[Int]): Array[Int] = {
    def loop(nums: Array[Int], i: Int = nums.length - 1): Array[Int] =
      if (i < 0) nums
      else {
        for {
          j <- 0 until i
        } yield {
          println(s"i: $i after nums: ${nums.mkString(" ")}")
          if (nums(j) < nums(j + 1)) {
            val temp = nums(j)
            nums(j) = nums(j + 1)
            nums(j + 1) = temp
          }
        }
//        println(s"i: $i after nums: ${nums.mkString(" ")}")
        loop(nums, i - 1)
      }
    loop(nums)
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(3, 2, 1, 4, 9, 6, 5, 8, 7, 0)
    println(bubbleSort(nums).mkString(" "))
  }
//    {
//      val nums = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//      println(bubbleSort(nums).mkString(" "))
//    }
//    {
//      val nums = Array(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
//      println(bubbleSort(nums).mkString(" "))
//    }

}
