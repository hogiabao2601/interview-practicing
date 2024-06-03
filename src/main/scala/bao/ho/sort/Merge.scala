package bao.ho.sort

object Merge {

  def mergSort(nums: Array[Int]): Array[Int] =
    if (nums.length <= 1) nums
    else {
      val (left, right) = nums.splitAt(nums.length / 2)
      merge(mergSort(left), mergSort(right))
    }

  def merge(leftNums: Array[Int], rightNums: Array[Int]): Array[Int] = {
    def loop(leftIndex: Int = 0, rightIndex: Int = 0, result: Array[Int] = Array()): Array[Int] =
      if (leftIndex == leftNums.length) result ++ rightNums.drop(rightIndex)
      else if (rightIndex == rightNums.length) result ++ leftNums.drop(leftIndex)
      else {
        if (leftNums(leftIndex) < rightNums(rightIndex)) {
          loop(leftIndex + 1, rightIndex, result :+ leftNums(leftIndex))
        } else {
          loop(leftIndex, rightIndex + 1, result :+ rightNums(rightIndex))
        }
      }
    loop()
  }

  def main(args: Array[String]): Unit = {
    {
      val nums = Array(3, 2, 1, 4, 9, 6, 5, 8, 7, 0)
      println(mergSort(nums).mkString(" "))
    }
    {
      val leftNums  = Array(1)
      val rightNums = Array(2)
      println(merge(leftNums, rightNums).mkString(" "))
    }
    {
      val leftNums  = Array(1, 3)
      val rightNums = Array(2, 4)
      println(merge(leftNums, rightNums).mkString(" "))
    }
    {
      val leftNums  = Array(1, 3, 5)
      val rightNums = Array(2, 4, 6)
      println(merge(leftNums, rightNums).mkString(" "))
    }
  }

}
