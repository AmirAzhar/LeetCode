// 947. Most Stones Removed with Same Row or Column
// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/

const removeStones = (stones) => {
  // Keep track of all visited stones
  const visited = new Set();

  // Keep track of number of stones not needed to be removed
  let valid = 0;

  const DFS = (xPos, yPos) => {
    // Get the id of the stone based on the row and col
    const id = `${xPos}-${yPos}`;

    // If already visited, we should not continue the search
    if (visited.has(id)) return;

    // Here, we have not visited the stone, so we add into the set
    visited.add(id);

    // Iterate through the stones to find if there are any stones in same row/col as curr stone
    for (const [xOther, yOther] of stones)
      if (xPos === xOther || yPos === yOther) DFS(xOther, yOther);
  };

  for (const [xPos, yPos] of stones) {
    // Get the id of the stone based on the row and col
    const id = `${xPos}-${yPos}`;

    // If already visited, we skip the stone
    if (visited.has(id)) continue;

    // Perform DFS to look for neighbours in same row and col
    DFS(xPos, yPos);

    // If we reach here, it means that the stone has no neighbours in the same row and col
    valid++;
  }

  return stones.length - valid;
};
