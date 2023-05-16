// 931. Minimum Falling Path Sum
// https://leetcode.com/problems/minimum-falling-path-sum/

function minFallingPathSum(matrix) {
  // Create a new matrix with the same dimensions as the input matrix
  // to store the minimum sums of each falling path.
  const minSums = [...Array(matrix.length)].map((row) =>
    Array(matrix[0].length).fill(Infinity)
  );

  // Initialize the minimum sums in the first row to be the same as
  // the values in the first row of the input matrix.
  minSums[0] = matrix[0];

  // Iterate over the remaining rows in the matrix (starting from the second row).
  for (let row = 1; row < matrix.length; row++) {
    // Iterate over the columns in the current row.
    for (let col = 0; col < matrix[0].length; col++) {
      // Consider the three possible paths from the current element to
      // the element in the previous row: directly above, diagonally
      // above and to the left, and diagonally above and to the right.
      // The minimum sum for the current element is the minimum of the
      // minimum sums of these three paths, plus the value of the
      // current element.
      minSums[row][col] =
        Math.min(
          minSums[row - 1][col],
          minSums[row - 1][Math.max(0, col - 1)],
          minSums[row - 1][Math.min(matrix[0].length - 1, col + 1)]
        ) + matrix[row][col];
    }
  }

  // Return the minimum of the minimum sums of all elements in the last row.
  // This is the minimum sum of any falling path in the matrix.
  return Math.min(...minSums[minSums.length - 1]);
}
