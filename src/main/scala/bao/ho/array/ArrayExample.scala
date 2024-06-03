package bao.ho.array

import scala.annotation.tailrec

object ArrayExample {

  @tailrec
  private def findBiggestV1(arr: Array[Int], result: Int = Int.MinValue): Int = {
    arr match {
      case Array() => result
      case Array(x, _*) => if (x > result) findBiggestV1(arr.tail, x) else findBiggestV1(arr.tail, result)
    }
  }

  @tailrec
  private def findBiggestV2(arr: Array[Int], i: Int = 0, result: Int = Int.MinValue): Int = {
    if (i == arr.length) {
      result
    } else {
      if (arr(i) > result) {
        findBiggestV2(arr, i + 1, arr(i))
      } else {
        findBiggestV2(arr, i + 1, result)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 20, 6, 7, 8, 9, 10)
    println(findBiggestV1(arr))
    println(findBiggestV2(arr))
  }
}
