package bao.ho.sliding_window

object _219 {
  //      else {
  //        if ()
  //          loop(start, end, true)
  //        else {
  //
  //        }
  ////            loop(start, end + 1, result)
  ////          }
  ////        } else loop(start + 1, end, result)
  //      }

//  k = 3
//  s | e = 0 | 1  -> 1  < k
//  s | e = 0 | 2  -> 2  < k
//  s | e = 1 | 2  -> 1  < k
//  s | e = 0 | 3  -> 3  = k
//  s | e = 1 | 3  -> 2  < k
//  s | e = 2 | 3  -> 1  < k
//  s | e = 1 | 4  -> 3  = k
//  s | e = 2 | 4  -> 2  < k
//  s | e = 3 | 4  -> 1  < k
//  s | e = 2 | 5  -> 3  = k
//  s | e = 3 | 5  -> 2  < k
//  s | e = 4 | 5  -> 1  < k
//  def containsNearbyDuplicateV1(nums: Array[Int], k: Int): List[(Int, Int)] =
//    for {
//      i <- nums.indices.toList
//      j <- i - k to i
//      if i != j
//    } yield (i, j)

  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    def loop(start: Int = 0, end: Int = 1, result: Boolean = false): Boolean =
      if (end == nums.length || result) {
        result
      } else {
        if (start == end) {
          val newStart = if (end - k > 0) end - k + 1 else 0
          loop(newStart, end + 1, result)
        } else {
          if (nums(start) == nums(end) && end - start <= k) loop(start, end + 1, true)
          else {
            loop(start + 1, end, result)
          }
        }
      }
    if (k == 0) false else loop()
  }

  def main(args: Array[String]): Unit = {
//    {
//      val nums = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 9)
//      val k    = 3
//      println(containsNearbyDuplicate(nums, k))
////      println(containsNearbyDuplicate(nums, k) == true)
//    }
    {
      val nums = Array(1, 2, 1)
      val k    = 1
      println(containsNearbyDuplicate(nums, k) == false)
    }
    {
      val nums = Array(1, 2, 3, 1, 2, 3)
      val k    = 2
      println(containsNearbyDuplicate(nums, k) == false)
    }
    {
      val nums = Array(0, 1, 2, 3, 2, 5)
      val k    = 3
      println(containsNearbyDuplicate(nums, k) == true)
    }
    {
      val nums = Array(1, 2, 1)
      val k    = 0
      println(containsNearbyDuplicate(nums, k) == false)
    }
    {
      val nums = Array(1, 2, 3, 1)
      val k    = 3
      println(containsNearbyDuplicate(nums, k) == true)
    }
    {
      val nums = Array(1, 0, 1, 1)
      val k    = 1
      println(containsNearbyDuplicate(nums, k) == true)
    }

  }
}
