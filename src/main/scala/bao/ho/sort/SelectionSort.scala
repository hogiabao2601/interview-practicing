package bao.ho.sort

object SelectionSort {

//  https://www.youtube.com/watch?v=g-PGLbMth_g
  def selectionSort(nums: Array[Int]): Array[Int] = {
    def loop(nums: Array[Int], i: Int = 0, current: Int = 0, picking: Int = 0): Array[Int] =
      if (i >= nums.length) nums
      else {
        if (current >= nums.length) {
          val temp = nums(i)
          nums(i) = nums(picking)
          nums(picking) = temp
          loop(nums, i + 1, i + 1, i + 1)
        } else {
          if (nums(current) < nums(picking)) {
            loop(nums, i, current + 1, current)
          } else
            loop(nums, i, current + 1, picking)
        }
      }
    loop(nums)
  }

  def sort(nums: Array[Int]): Array[Int] = {
    for {
      i <- 0 until nums.length - 1
      j <- i + 1 until nums.length
    } yield {
      if (nums(i) > nums(j)) {
        val temp = nums(i)
        nums(i) = nums(j)
        nums(j) = temp
      }
    }
    nums
  }
  def main(args: Array[String]): Unit = {
    val nums = Array(3, 2, 1, 4, 9, 6, 5, 8, 7, 0)
    println(selectionSort(nums).mkString(" "))
  }

}
