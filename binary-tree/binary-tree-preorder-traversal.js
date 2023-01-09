// 144. Binary Tree Preorder Traversal
// https://leetcode.com/problems/binary-tree-preorder-traversal%20/description/

var preorderTraversal = function (root) {
  // Base Case: If the tree is empty, simply return an empty array
  if (!root) return [];

  const stack = [root];
  const res = [];

  // We use a stack to keep track of all the nodes
  while (stack.length) {
    // Pop a node to signify that we have visited the node, and add the value to res
    const curr = stack.pop();
    res.push(curr.val);

    // If the children exists, add them to the stack
    if (curr.right) stack.push(curr.right);
    if (curr.left) stack.push(curr.left);
  }

  return res;
};
