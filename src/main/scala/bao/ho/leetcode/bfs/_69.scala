package bao.ho.leetcode.bfs

object _69 {

  def mySqrt(x: Int): Int = {
    def loop(x: Int, l: Int = 1, r: Int = x, result: Int = 1): Int =
      if (l > r)
        result
      else {
        val M        = l + (r - l) / 2
        val M2: Long = M.toLong * M.toLong
        M2 match {
          case i if i == x => M
          case i if i > x  => loop(x, l, M - 1, result)
          case _           => loop(x, M + 1, r, M)
        }
      }

    if (x == 0) 0 else loop(x)
  }

  def main(args: Array[String]): Unit = {
    val x = 2147395599
    println(mySqrt(x))
  }
}
