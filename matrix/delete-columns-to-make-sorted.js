// 944. Delete Columns to Make Sorted
// https://leetcode.com/problems/delete-columns-to-make-sorted/description/

var minDeletionSize = function (strs) {
  // Keeps track of the number of columns to delete
  let count = 0;

  // Iterate through each character (col)
  for (let col = 0; col < strs[0].length; col++) {
    // Iterate through each string (row), but stop at the 2nd last row
    for (let row = 0; row < strs.length - 1; row++) {
      // if the next char is lexicographically greater than the current, increase the count and move on to the next column
      if (strs[row][col] > strs[row + 1][col]) {
        count += 1;
        break;
      }
    }
  }
  return count;
};
