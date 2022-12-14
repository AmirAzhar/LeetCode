// 623. Add One Row to Tree
// https://leetcode.com/problems/add-one-row-to-tree/description/

function addOneRow(root, val, depth) {
  // Base Case: Depth is 1
  if (depth === 1) return new TreeNode(val, root, null);

  // Using BFS queue to go down to the depth
  let q = [...[root]];
  depth--;

  while (depth > 0) {
    depth--;
    let levelLength = q.length;

    for (let index = 0; index < levelLength; index++) {
      // Visited the node
      let currNode = q.shift();

      // Once we reach the required depth, we add the new nodes to the left and right
      if (depth == 0) {
        currNode.left = new TreeNode(val, currNode.left);
        currNode.right = new TreeNode(val, null, currNode.right);
        continue;
      }

      // Discovered nodes
      // Add the nodes to the queue to visit later
      if (currNode.left) q.push(currNode.left);
      if (currNode.right) q.push(currNode.right);
    }
  }
  return root;
}
