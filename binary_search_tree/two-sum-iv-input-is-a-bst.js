// 653. Two Sum IV - Input is a BST
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

var findTarget = function(root, k) {
    // Base Case
    if (!root) return false;
    
    // Use a set to keep track of values of visited notes
    const set = new Set();

    // Use a stack for DFS, to look for nodes
    const stack = [root];
    
    while (stack.length) {
        const node = stack.pop();

        // if the complenment of node.val has alrady been visited, means there is a pair and hence, true
        let target = k - node.val
        if (set.has(target)) return true;

        // Visited the node
        set.add(node.val);

        // Discovered the node, so add to the stack
        if (node.right) stack.push(node.right);
        if (node.left) stack.push(node.left);
  }
  return false;
};