// 222. Count Complete Tree Nodes
// https://leetcode.com/problems/count-complete-tree-nodes/description/

var countNodes = function (root) {
  // DFS: Base case if reach a null node, else, we recursively go through the left and right child nodes
  return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
};
