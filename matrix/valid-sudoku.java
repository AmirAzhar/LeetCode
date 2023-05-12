// 36. Valid Sudoku
// https://leetcode.com/problems/valid-sudoku/description/

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isValidSudoku(char[][] board) {

    // Create a set to keep track of elements
    Set seen = new HashSet();

    // Iterate through each element
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {

        // Get the current element
        char number = board[i][j];

        // If it is not empty, add the number in the set
        // eg. "5 in row 0", "5 in col 1", "5 in box 0-0"
        // If any of these are in already in the set, it means there are duplicate
        // number in row/col/box
        if (number != '.')
          if (!seen.add(number + " in row " + i) ||
              !seen.add(number + " in col " + j) ||
              !seen.add(number + " in box " + i / 3 + "-" + j / 3))
            return false;
      }
    }

    // If all elements can be added to set, means that it is a valid sudoku
    return true;
  }
}