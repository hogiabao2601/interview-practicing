package leetcode_75

object _605 {

//  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
//    def loop(flowerbed: Array[Int], n: Int, i: Int = 1, result: Boolean = true): Boolean =
//      if (n == 0 || i >= flowerbed.length) result
//      else {
//        val canBePlanted = flowerbed(i - 1) == 0 && flowerbed(i) == 0 && flowerbed(i + 1) == 0
//        val newResult    = canBePlanted
//        if (canBePlanted)
//          loop(flowerbed, n - 1, i + 2, newResult)
//        else
//          loop(flowerbed, n, i + 1, newResult)
//      }
//    loop(flowerbed, n)
//
//  }

  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean =
    if (n == 0)
      true
    else
      flowerbed match {
        case Array()         => false
        case Array(0)        => n == 1
        case Array(0, 0, _*) => canPlaceFlowers(flowerbed.drop(2), n - 1)
        case Array(1, 0, _*) => canPlaceFlowers(flowerbed.drop(2), n)
        case Array(_, _*)    => canPlaceFlowers(flowerbed.tail, n)
      }

  def main(args: Array[String]): Unit = {


    val flowerbed = Array(1,0,0,0,0,0,1)
    val n         = 2
    println(canPlaceFlowers(flowerbed, n))
  }

}
