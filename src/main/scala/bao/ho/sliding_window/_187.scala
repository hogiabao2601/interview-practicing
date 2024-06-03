package bao.ho.sliding_window

object _187 {

  def findRepeatedDnaSequences(s: String): List[String] = {
    def loop(s: String, table: Map[String, Int] = Map[String, Int]()): List[String] = {
      if (s.length < 10)
        table.filter { case (_, value) => value >= 2 }.keys.toList
      else {
        val substring  = s.substring(0, 10)
        val newKeyPair = Map[String, Int](substring -> (table.getOrElse(substring, 0) + 1))
        loop(s.tail, table ++ newKeyPair)
      }
    }
    loop(s)
  }

  def main(args: Array[String]): Unit = {}
}
