// 1519. Number of Nodes in the Sub-Tree With the Same Label
// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/

var countSubTrees = function (n, edges, labels) {
  let array = new Array(n);

  // Create a adjency list of k:v where k -> vertex and v -> list of neighbouring nodes
  let a = {};

  // Create a placeholder array for each vertex in the adjency list
  for (let i = 0; i < n; i++) a[i] = [];

  // Iterate through the edges and update the adjency list
  for (let x of edges) {
    a[x[0]].push(x[1]);
    a[x[1]].push(x[0]);
  }

  dfs(-1, 0, a, labels, array);
  return array;
};

function dfs(prev, curr, a, labels, array) {
  const ans = new Array(26).fill(0);

  for (let x of a[curr]) {
    if (x !== prev) {
      let res = dfs(curr, x, a, labels, array);
      for (let i = 0; i < 26; i++) ans[i] += res[i];
    }
  }

  array[curr] = ++ans[labels.charCodeAt(curr) - "a".charCodeAt(0)];
  return ans;
}
