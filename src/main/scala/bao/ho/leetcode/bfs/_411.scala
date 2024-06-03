package bao.ho.leetcode.bfs

object _411 {

  def arrangeCoinsV1(n: Int): Int = {
    val maxLevel = math.sqrt(2.toLong * n).toInt
    val dp       = Array.fill(maxLevel)(0)
    dp(0) = 1
    for {
      i <- 1 until maxLevel
    } yield dp(i) = dp(i - 1) + i + 1
    if (dp(maxLevel - 1) - n > 0) maxLevel - 1 else maxLevel
  }

  def arrangeCoins(n: Int): Int = {
    def loop(n: Int, result: Int = 0): Int =
      if (n == 0) result
      else if (n < 0) result - 1
      else loop(n - result - 1, result + 1)
    loop(n)
  }

  def main(args: Array[String]): Unit = {
    val n = 1804289383
    println(arrangeCoinsV1(n))
    println(arrangeCoins(n))
  }

}
