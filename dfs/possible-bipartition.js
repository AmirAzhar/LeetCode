// 886. Possible Bipartition
// https://leetcode.com/problems/possible-bipartition/description/

function possibleBipartition(n, dislikes) {
  // Create an adjacency list representation of the dislikes graph
  const adjList = new Array(n + 1);
  for (let i = 1; i <= n; i++) {
    adjList[i] = [];
  }
  for (const [a, b] of dislikes) {
    adjList[a].push(b);
    adjList[b].push(a);
  }

  // Initialize an array to keep track of which group each person is in
  const groups = new Array(n + 1).fill(-1);

  // Iterate through each person and try to assign them to a group
  for (let i = 1; i <= n; i++) {
    if (groups[i] === -1) {
      // If this person has not yet been assigned to a group, try to assign them to group 0
      if (!dfs(i, 0)) {
        // If we can't assign this person to group 0, then it's not possible to split the groups
        return false;
      }
    }
  }

  // If we were able to assign everyone to a group, then it is possible to split the groups
  return true;

  // Depth-first search function to try and assign person `p` to group `group`
  function dfs(p, group) {
    // If this person has already been assigned to a group, return whether it is the same group we are trying to assign them to
    if (groups[p] !== -1) {
      return groups[p] === group;
    }

    // Otherwise, assign this person to the group we are trying to assign them to
    groups[p] = group;

    // Try to assign all of this person's disliked people to the other group
    for (const q of adjList[p]) {
      if (!dfs(q, 1 - group)) {
        // If we can't assign one of this person's disliked people to the other group, then it's not possible to split the groups
        return false;
      }
    }

    // If we were able to assign all of this person's disliked people to the other group, then it is possible to split the groups
    return true;
  }
}
