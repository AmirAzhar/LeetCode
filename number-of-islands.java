// https://leetcode.com/problems/number-of-islands/description/

// Java
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') { 
                    dfs(grid, r, c);
                    res++; 
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length, cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}

// JS
var numIslands = function(grid) {
    let res = 0;
    const rows = grid.length;
    const cols = grid[0].length;

    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];

    const BFS = (r, c) => {
        const queue = [[r, c]];
        grid[r][c] = '0';

        while (queue.length > 0) {
            const [currRow, currCol] = queue.shift();

            for (const [dr, dc] of directions) {
                const newRow = currRow + dr;
                const newCol = currCol + dc;

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] === '1') {
                    queue.push([newRow, newCol]);
                    grid[newRow][newCol] = '0';
                }
            }
        }
    };

    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (grid[r][c] === '1') {
                BFS(r, c);
                res++;
            }
        }
    }

    return res;
};
