// https://leetcode.com/problems/search-a-2d-matrix/description/

// Java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int l = 0, r = rows * cols - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) return true;
            else if (midValue > target) r = mid - 1;
            else l = mid + 1;
        }

        return false;
    }
}

// we need perform binary search across the whole matrix
// to simulate it as a flat array

// Each row has cols elements
// So after every cols steps, you move to the next row
// Division by cols tells you how many full rows you've moved past (i.e., which row you're in).
    // mid / cols → gives you the row index
// Modulo cols tells you your position within that row (i.e., column).
    // mid % cols → gives you the column index