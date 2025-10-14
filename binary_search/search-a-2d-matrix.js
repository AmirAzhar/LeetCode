// https://leetcode.com/problems/search-a-2d-matrix/description/

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  let rows = matrix.length,
    cols = matrix[0].length;
  let l = 0,
    r = rows * cols - 1;

  while (l <= r) {
    let m = Math.floor((l + r) / 2);
    let mVal = matrix[Math.floor(m / cols)][m % cols];

    if (mVal == target) return true;
    else if (mVal > target) r = m - 1;
    else l = m + 1;
  }

  return false;
};

// Time: O(log(m * n)) -> search space is entire matrix
// Space: O(1)

// i can do a binary search such that the index im looking for is m * n
// the trickey part is finding out given the index, which row and column the cell belongs to
// for a given index i, since there are n  ele (columns) in a row -> after every n steps, u move to next row
// to find row -> we can do i / n -> may need to floor but should tell us the row
// to find col -> we can do i % n -> remainder will tell us which column
