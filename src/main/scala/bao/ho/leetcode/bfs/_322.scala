package bao.ho.leetcode.bfs

object _322 {

  def coinChange(coins: Array[Int], amount: Int): Int = {
    val dp = Array.fill(amount + 1)(amount + 1)
    dp(0) = 0
    for {
      i    <- 0 to amount
      coin <- coins
      if i >= coin
    } yield dp(i) = math.min(dp(i), dp(i - coin) + 1)
    if (dp(amount) > amount) -1 else dp(amount)
  }

  def main(args: Array[String]): Unit = {
    val coins  = Array(1, 3, 4, 5)
    val amount = 7
    println(coinChange(coins, amount))
  }

}
