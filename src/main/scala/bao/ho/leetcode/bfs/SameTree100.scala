package bao.ho.leetcode.bfs

class SameTree100 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    def loop(p: TreeNode, q: TreeNode, result: Boolean = false): Boolean = {
      if (p == null && q == null) {
        result
      } else if (p == null || q == null) {
        false
      } else if (p.value != q.value) {
        false
      } else {
        loop(p.left, q.left) && loop(p.right, q.right)
      }
    }
    loop(p, q)
  }




}
