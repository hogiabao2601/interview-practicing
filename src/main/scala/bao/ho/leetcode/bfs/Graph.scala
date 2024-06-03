package bao.ho.leetcode.bfs

object Graph {
  private val nodeA: Node = Node("A", 3)
  private val nodeB: Node = Node("B", 1)
  private val nodeC: Node = Node("C", 4)
  private val nodeD: Node = Node("D", 0)
  private val nodeE: Node = Node("E", 5)
  private val nodeF: Node = Node("F", 9)
  private val nodeG: Node = Node("G", 8)
  private val nodeH: Node = Node("H", 7)
  private val nodeI: Node = Node("I", 11)

  val graph: List[Edge] = List(
    Edge(nodeA, nodeB, 2),
    Edge(nodeD, nodeI, 8),
    Edge(nodeA, nodeC, 4),
    Edge(nodeA, nodeF, 11),
    Edge(nodeC, nodeH, 3),
    Edge(nodeB, nodeD, 5),
    Edge(nodeB, nodeE, 1),
    Edge(nodeC, nodeG, 7)
  )

//  Array[Int]() += 1

  def bfs(graph: List[Edge], startNode: Node): List[Node] = {
    def loop(graph: List[Edge], startNode: Node, visited: List[Node], queue: List[Node]): List[Node] =
      queue match {
        case Nil => visited
        case head :: tail =>
          val newVisited = visited :+ head
          val newQueue   = tail ++ graph.filter(_.source == head).map(_.destination).filterNot(newVisited.contains)
          loop(graph, startNode, newVisited, newQueue)
      }

    loop(graph, startNode, List(), List(startNode))
  }

  def dfs(graph: List[Edge], startNode: Node): List[Node] = {
    def loop(graph: List[Edge], startNode: Node, visited: List[Node], stack: List[Node]): List[Node] =
      stack match {
        case Nil => visited
        case head :: tail =>
          val newVisited = visited :+ head
          val newStack   = graph.filter(_.source == head).map(_.destination).filterNot(newVisited.contains) ++ tail
          loop(graph, startNode, newVisited, newStack)
      }
    loop(graph, startNode, List(), List(startNode))
  }

  def main(args: Array[String]): Unit = {
    val bfsResult = bfs(graph, nodeA)
    val dfsResult = dfs(graph, nodeA)
    println(bfsResult)
    println(dfsResult)
  }
}
