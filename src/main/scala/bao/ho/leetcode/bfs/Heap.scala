package bao.ho.leetcode.bfs

object Heap {

  def printHeap(arr: Array[Int]): Unit = {
    val high = ((math.log(arr.length) / math.log(2)) + 1).toInt
    for (level <- 1 to high) {
      for (j <- math.pow(2, level - 1).toInt until math.pow(2, level).toInt) {
        if ((j - 1) < arr.length) print(" " * ((high + 2) - level) + arr(j - 1) + " " * ((high + 2) - level))
      }
      println()
    }
  }

  def childIndies(index: Int): (Int, Int) = ((index * 2) + 1, (index * 2) + 2)

  def getParentIndex(index: Int): Int = if (index > 0) (index - 1) / 2 else -1

  //  def createMaxHeap(arr: Array[Int]): Array[Int] = {
  //    def loop(arr: Array[Int], index: Int): Array[Int] = {
  //      val (left, right) = childIndies(index)
  //      if (arr(left) > arr(index)){
  //
  //      }
  //
  //    }
  //    loop(arr, 0)
  //
  //
  //  }

  def createHeap(arr: Array[Int]): Array[Int] = {
    var k = 0
    def loop(arr: Array[Int], index: Int = 0): Unit = {
      println(s"arr: ${arr.mkString(",")}, index: $index")
      k += 1
      if (index < arr.length) {
        val parent = getParentIndex(index)
        if (parent >= 0 && arr(parent) < arr(index)) {
          val temp = arr(parent)
          arr(parent) = arr(index)
          arr(index) = temp
          loop(arr, parent)
        } else {
          loop(arr, index + 1)
        }
      }
    }

    loop(arr)
    println(s"${arr.length} loop: $k")
    arr
  }

  def addHeap(heap: Array[Int], value: Int): Array[Int] = ???

  def removeHeap(heap: Array[Int], value: Int): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    val arr  = Array(10, 15, 20, 30)
    val heap = createHeap(arr)
    println(heap.mkString(","))

    // arr.indices.foreach(i => {
    //   val (left, right) = childIndies(i)
    //   println(s"parent: ${arr(i)}")
    //   if (left < arr.length) println(s" left: ${arr(left)}")
    //   if (right < arr.length) println(s" right: ${arr(right)}")
    // })
//    printHeap(arr)
//    val heap =
  }

}
