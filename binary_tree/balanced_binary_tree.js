// 110. Balanced Binary Tree
// https://leetcode.com/problems/balanced-binary-tree/description/

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
 * @return {boolean}
 */
const isBalanced1 = (root) => {
  const depth = (root) =>
    !root ? 0 : 1 + Math.max(depth(root.left), depth(root.right));
  return !root
    ? true
    : Math.abs(depth(root.left) - depth(root.right)) < 2 &&
        isBalanced(root.left) &&
        isBalanced(root.right);
};

// Time: O(n^2)
// Space: O(1)
// for a tree to be height balanced, need to fulfill 2 conditions - (1) height of left and right subtree must be within 1 AND (2) the left and right subtrees must be balanced
// Base case: if root is empty, it is balanced
// create a helper function to calculate height
// base case: reach a null node, it is 0
// recursively add 1 to the height of a node until it reaches the end
// use the hight function to compare the heights of the left and right subtrees, and also recursively checking if they are balanced

const dfs = (root) => {
  if (!root) return 0;
  const leftDepth = dfs(root.left),
    rightDepth = dfs(root.right);
  if (
    leftDepth == -1 ||
    rightDepth == -1 ||
    Math.abs(leftDepth - rightDepth) > 1
  )
    return -1;
  return Math.max(leftDepth, rightDepth) + 1;
};

const isBalanced2 = (root) => {
  return dfs(root) != -1;
};

// Time: O(n)
// Space: O(1)
// The second method is based on DFS. Instead of calling depth() explicitly for each child node, we return the height of the current node in DFS recursion. When the sub tree of the current node (inclusive) is balanced, the function dfsHeight() returns a non-negative value as the height. Otherwise -1 is returned. According to the leftHeight and rightHeight of the two children, the parent node could check if the sub tree is balanced, and decides its return value. In this bottom up approach, each node in the tree only need to be accessed once.
