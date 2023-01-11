// 1443. Minimum Time to Collect All Apples in a Tree
// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

var minTime = function (n, edges, hasApple) {
  // Create a adjency list of k:v where k -> vertex and v -> list of neighbouring nodes
  let a = {};

  // Create a placeholder array for each vertex in the adjency list
  for (let i = 0; i < n; i++) a[i] = [];

  // Iterate through the edges and update the adjency list
  for (let x of edges) {
    a[x[0]].push(x[1]);
    a[x[1]].push(x[0]);
  }

  // Perform recursive dfs starting from root node
  return dfs(-1, 0, a, hasApple);
};

function dfs(prev, curr, a, hasApple) {
  let ans = 0;
  for (let x of a[curr]) {
    if (x !== prev) {
      let res = dfs(curr, x, a, hasApple);
      if (res > 0 || hasApple[x]) ans += res + 2;
    }
  }
  return ans;
}
