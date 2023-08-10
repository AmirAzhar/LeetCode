// 733. Flood Fill
// https://leetcode.com/problems/flood-fill/

/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
var floodFill = function (image, sr, sc, targetColor) {
  const startColor = image[sr][sc];
  if (startColor === targetColor) return image;

  function dfs(row, col) {
    if (
      row < 0 ||
      row >= image.length ||
      col < 0 ||
      col >= image[0].length ||
      image[row][col] != startColor
    )
      return;
    image[row][col] = targetColor;
    dfs(row + 1, col);
    dfs(row - 1, col);
    dfs(row, col + 1);
    dfs(row, col - 1);
  }

  dfs(sr, sc);

  return image;
};

// O(V + E) where V is the number of vertices and E is the number of edges
// O(bm) where m is max depth and b is branching factor
// get startColor as image[sr][sc]
// if startColor is already the targetColor, return the image
// perform depth first search
// check if cell is within boundary and is same color as startColor
// change color of cell to targetColor
// dfs on cells on the 2 axis (top, bottom, left, right)
