// 235. Lowest Common Ancestor of a Binary Search Tree
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
  while (root) {
    if (root.val < p.val && root.val < q.val) root = root.right;
    else if (root.val > p.val && root.val > q.val) root = root.left;
    else return root;
  }
};

// Time: O(h) where h is the height of the tree
// Space: O(1)
// the lowest common ancestor of 2 nodes in a binary tree is the node with the lowest value x such that p.val <= x <= q.val
// the node which is deeper in the tree will be a lower common acestor compared to one above it
// travers the tree
// if a the node's val is between p.val and q.val, set that at the lowest
// else, if the val of the node is too high, traverse the left child
// else, if the val of the node is too low, traverse the right child
