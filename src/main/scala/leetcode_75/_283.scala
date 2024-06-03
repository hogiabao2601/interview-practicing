package leetcode_75

object _283 {

  def moveZeroes(nums: Array[Int]): Unit = {
    var nonZeroIndex = 0
    for (i <- nums.indices) {
      if (nums(i) != 0) {
        nums(nonZeroIndex) = nums(i)
        nonZeroIndex += 1
      }
    }
    for (i <- nonZeroIndex until nums.length)
      nums(i) = 0
  }
  "".tail

  Map[String, Int]().getOrElse("a", 0)
  "".substring(0, 0)
  def main(args: Array[String]): Unit = {
    {
      val nums = Array(0, 1, 0, 3, 12)
      moveZeroes(nums)
      println(nums.mkString(" "))
    }
    {
      val nums = Array(0, 0, 1)
      moveZeroes(nums)
      println(nums.mkString(" "))
    }
    {
      val nums = Array(0)
      moveZeroes(nums)
      println(nums.mkString(" "))
    }
  }

}
