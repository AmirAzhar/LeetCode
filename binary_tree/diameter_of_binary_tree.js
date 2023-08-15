// 543. Diameter of Binary Tree
// https://leetcode.com/problems/diameter-of-binary-tree/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree = function (root) {
  let res = 0;

  const dfs = (root) => {
    if (!root) return 0;
    const left = dfs(root.left);
    const right = dfs(root.right);

    res = Math.max(res, left + right);

    return Math.max(left, right) + 1;
  };

  dfs(root);

  return res;
};

// Time: O(n) where n is number of nodes
// Space: O(h) where h is height of tree -> max number of function calls in the stack will equal the height of the tree

// use dfs to traverse the tree
// the max diameter can easily be the sum of the left and right depths
// keep finding the left and right depths at each node
