// https://leetcode.com/problems/game-of-life/

// Java
class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] directions = {
            {0, -1}, {-1, 0}, {1, 0}, {0, 1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}
        };

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                int neighbours = 0;

                for (int[] dir : directions){
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    
                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && (board[newR][newC] == -2 || board[newR][newC] == 1)) neighbours++;
                }

                if (board[r][c] == 1 && (neighbours < 2 || neighbours > 3)) board[r][c] = -2;
                else if (board[r][c] == 0 && neighbours == 3) board[r][c] = 2;
            }
        }

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (board[r][c] == -2) board[r][c] = 0;
                if (board[r][c] == 2) board[r][c] = 1;
            }
        }
    }
}

// for each cell
    // check its neighbours, to find how many live neighbours
        // check if within bounds
        // check if 1 or -2
    // update value of the cell based on rules
        // to use the same board, we need to mark
            // live -> dead -2
            // dead -> live 2