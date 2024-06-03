package leetcode_75

object _238 {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val n = nums.length

    // Initialize the left and right product arrays
    val leftProducts  = Array.fill(n)(1)
    val rightProducts = Array.fill(n)(1)
    val answer        = Array.fill(n)(1)

    // Fill the leftProducts array
    for (i <- 1 until n) {
      leftProducts(i) = leftProducts(i - 1) * nums(i - 1)
    }

    // Fill the rightProducts array
    for (i <- (0 until (n - 1)).reverse) {
      rightProducts(i) = rightProducts(i + 1) * nums(i + 1)
    }

    // Fill the answer array by multiplying left and right products
    for (i <- 0 until n) {
      answer(i) = leftProducts(i) * rightProducts(i)
    }

    answer
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 3, 4)
    println(productExceptSelf(nums).mkString(" "))
  }
}
