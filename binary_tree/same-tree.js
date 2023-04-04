// 100. Same Tree
// https://leetcode.com/problems/same-tree/description/

var isSameTree = function (p, q) {
  // If either one is null, return true if both null, but false if only one of them is null
  if (!p || !q) return p === q;

  // If the values of the nodes are different, the tree is immediately not the same
  if (p.val != q.val) return false;

  // Recursively compare its children
  return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
};
