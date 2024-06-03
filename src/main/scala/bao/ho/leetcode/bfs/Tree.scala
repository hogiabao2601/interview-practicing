package bao.ho.leetcode.bfs

object Tree {
  val sampleTree = MyTree(1, List(MyTree(2, List(MyTree(4), MyTree(5))), MyTree(3, List(MyTree(6, List(MyTree(8))), MyTree(7)))))

  def printTree(tree: MyTree): Unit = {
    def loop(tree: MyTree, level: Int): Unit = {
      println("  " * level + tree.value)
      tree.nodes.foreach(node => loop(node, level + 1))
    }
    loop(tree, 0)
  }

  def main(args: Array[String]): Unit =
    printTree(sampleTree)
}
