package bao.ho.sliding_window

object _209 {

  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
    def loop(left: Int, right: Int, sum: Int, minLen: Int = 0): Int =
      if (right >= nums.length) {
        minLen
      } else {
        val current = sum + nums(right)
        if (current < target) {
          loop(left, right + 1, current, minLen)
        } else {
          val newMinLen = math.min(minLen, right - left + 1)
          loop(left + 1, right, sum - nums(left), newMinLen)
        }
      }

    val tempMinLen = nums.length + 1
    val result     = loop(0, 0, 0, tempMinLen)
    if (result == tempMinLen) 0 else result
  }

  def main(args: Array[String]): Unit = {
    {
      val target = 7
      val nums   = Array(2, 3, 1, 2, 4, 3)
      println(minSubArrayLen(target, nums))
    }
    {
      val target = 4
      val nums   = Array(1, 4, 4)
      println(minSubArrayLen(target, nums))
    }
    {
      val target = 11
      val nums   = Array(1, 1, 1, 1, 1, 1, 1)
      println(minSubArrayLen(target, nums))
    }
  }

}
