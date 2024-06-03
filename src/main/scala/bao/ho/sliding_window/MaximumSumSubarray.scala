package bao.ho.sliding_window

//Given an array of positive integers and a positive number k, find the maximum sum of any contiguous subarray of size k.
//  Input: [3, 5, 2, 1, 7], k=2
//  Output: 8

//The subarray [1, 7] is the sum of the maximum sum.

object MaximumSumSubarray {

  def findMaxSum(array: Array[Int], k: Int): Int = {
    var sum   = 0
    var start = 0
    var max   = 0
    for (i <- array.indices) {
      sum += array(i)
      if ((i - start) + 1 == k) {
        max = math.max(sum, max)
        sum -= array(start)
        start += 1
      }
    }
    max
  }

  def numOfSubarrays(arr: Array[Int], k: Int, threshold: Int): Int = {
    var sum   = 0
    var start = 0
    var count = 0
    for (i <- arr.indices) {
      sum += arr(i)
      if ((i - start) + 1 == k) {
        if (sum * 1.0 / k >= threshold) count += 1 else count += 0
        sum -= arr(start)
        start += 1
      }
    }
    count
  }

  List().lastOption

  def numOfSubarraysV2(array: Array[Int], k: Int, threshold: Int): Int = {
    def loop(l: Int = 0, r: Int = 0, current: Int = 0, result: Int = 0): Int =
      if (r == array.length)
        result
      else {
        val sum = current + array(r)
        if (r - l + 1 == k) {
          val count = result + (if (sum * 1.0 / k >= threshold) 1 else 0)
          loop(l + 1, r + 1, sum - array(l), count)
        } else
          loop(l, r + 1, sum, result)
      }
    loop()
  }

  def findMaxSumV2(array: Array[Int], k: Int): Int = {
    def loop(array: Array[Int], k: Int, l: Int = 0, r: Int = 0, current: Int = 0, result: Int = 0): Int =
      if (r == array.length)
        result
      else {
        val sum = current + array(r)
        if (r - l + 1 == k)
          loop(array, k, l + 1, r + 1, sum - array(l), math.max(sum, result))
        else
          loop(array, k, l, r + 1, sum, math.max(current, result))
      }

    loop(array, 2)
  }

  def main(args: Array[String]): Unit = {
//    val arr = Array(3, 5, 2, 1, 7)
//    println(findMaxSumV2(arr, 2))
    val arr1 = Array(11, 13, 17, 23, 29, 31, 7, 5, 2, 3)
    println(numOfSubarraysV2(arr1, 3, 5))

  }
}
