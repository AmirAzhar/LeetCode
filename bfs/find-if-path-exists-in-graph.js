// 1971. Find if Path Exists in Graph
// https://leetcode.com/problems/find-if-path-exists-in-graph/description/

function validPath(n, edges, start, end) {
  // Create a hashmap to be used as our adjacency list
  const graph = new Map();

  // Create a set to store our visited nodes
  const visited = new Set();

  // Build adjacency list (undirected)
  for (const [v, e] of edges) {
    if (graph.has(v)) {
      graph.get(v).push(e);
    } else {
      graph.set(v, [e]);
    }

    if (graph.has(e)) {
      graph.get(e).push(v);
    } else {
      graph.set(e, [v]);
    }
  }

  // Create a stack for DFS
  const stack = [start];

  // Perform DFS
  while (stack.length > 0) {
    const vertex = stack.pop();
    if (vertex === end) {
      return true;
    }
    visited.add(vertex);
    for (const neighbor of graph.get(vertex) || []) {
      if (!visited.has(neighbor)) {
        stack.push(neighbor);
      }
    }
  }
  return false;
}
