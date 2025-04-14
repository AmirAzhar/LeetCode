// https://leetcode.com/problems/pacific-atlantic-water-flow/

// DFS
// Java
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][][] reach = new boolean[rows][cols][2];

        for (int r = 0; r < rows; r++){
            dfs(heights, reach, rows, cols, r, 0, 0);
            dfs(heights, reach, rows, cols, r, cols - 1, 1);
        }

        for (int c = 0; c < cols; c++){
            dfs(heights, reach, rows, cols, 0, c, 0); 
            dfs(heights, reach, rows, cols, rows - 1, c, 1); 
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (reach[r][c][0] == true && reach[r][c][1] == true) res.add(Arrays.asList(r, c));
            }
        }

        return res;
    }

    public void dfs(int[][] heights, boolean[][][] reach, int rows, int cols, int row, int col, int ocean){
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        if (reach[row][col][ocean] == true) return;

        reach[row][col][ocean] = true;

        for (int[] dir : dirs){
            int newR = row + dir[0];
            int newC = col + dir[1];

            if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && heights[newR][newC] >= heights[row][col]) dfs(heights, reach, rows, cols, newR, newC, ocean); 
        }
    }
}

// JS
var pacificAtlantic = function(heights) {
    let rows = heights.length, cols = heights[0].length

    const reach = Array.from({ length: rows }, () =>
        Array.from({ length: cols }, () => [false, false])
    );

    const dirs = [[0,1], [1,0], [-1,0], [0,-1]];

    const dfs = (row, col, ocean) => {
        if (reach[row][col][ocean]) return;

        reach[row][col][ocean] = true;

        for (const dir of dirs){
            let newRow = row + dir[0];
            let newCol = col + dir[1];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && heights[newRow][newCol] >= heights[row][col]){
                dfs(newRow, newCol, ocean)
            }
        }
    }

    for (let r = 0; r < rows; r++){
        dfs(r, 0, 0); // pac
        dfs(r, cols - 1, 1); // atl
    }

    for (let c = 0; c < cols; c++){
        dfs(0, c, 0); // pac
        dfs(rows - 1, c, 1); // atl
    }

    const res = [];
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (reach[r][c][0] && reach[r][c][1]) {
                res.push([r, c]);
            }
        }
    }
    
    return res;
};

// BFS
// Java
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][][] reach = new boolean[rows][cols][2];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();


        for (int r = 0; r < rows; r++){
            pacQ.offer(new int[]{r, 0});
            atlQ.offer(new int[]{r, cols - 1});
        }

        for (int c = 0; c < cols; c++){
            pacQ.offer(new int[]{0, c});
            atlQ.offer(new int[]{rows - 1, c});
        }

        bfs(heights, reach, pacQ, 0);
        bfs(heights, reach, atlQ, 1);

        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (reach[r][c][0] == true && reach[r][c][1] == true) res.add(Arrays.asList(r, c));
            }
        }

        return res;
    }

    public void bfs(int[][] heights, boolean[][][] reach, Queue<int[]> queue, int ocean){
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int rows = heights.length;
        int cols = heights[0].length;

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            reach[row][col][ocean] = true;

            for (int[] dir : dirs){
                int newR = row + dir[0], newC = col + dir[1];
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && heights[newR][newC] >= heights[row][col] && !reach[newR][newC][ocean]) queue.offer(new int[]{newR, newC});
            
            }
        }
    }
}

//JS 
var pacificAtlantic = function(heights) {
    let rows = heights.length, cols = heights[0].length

    const reach = Array.from({ length: rows }, () =>
        Array.from({ length: cols }, () => [false, false])
    );

    let pacQ = [], atlQ = [];
    for (let r = 0; r < rows; r++){
        pacQ.push([r, 0]);
        atlQ.push([r, cols - 1]);
    }

    for (let c = 0; c < cols; c++){
        pacQ.push([0, c]);
        atlQ.push([rows - 1, c]);
    }

    const dirs = [[0,1], [1,0], [-1,0], [0,-1]];

    const bfs = (q, ocean) => {
        while (q.length) {
            let [row, col] = q.shift();

            reach[row][col][ocean] = true;

            for (const dir of dirs){
                let newR = row + dir[0];
                let newC = col + dir[1];
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && heights[newR][newC] >= heights[row][col] && !reach[newR][newC][ocean]) q.push([newR, newC])
            }
        }
    }

    bfs(pacQ, 0);
    bfs(atlQ, 1);

    const res = [];
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (reach[r][c][0] && reach[r][c][1]) res.push([r, c]);
        }
    }
    
    return res;
};

// Water can flow from a cell to neighboring cells with equal or lower height


// Instead of simulating water flow from every cell, simulate where water from oceans can reach
    // Start DFS from the ocean-adjacent cells
// Create a 2D array 'reach' to mark which cell is reachable from Pacific and Atlantic
    // Each cell stores a pair [pacificReachable, atlanticReachable]
// DFS traversal For each ocean, run DFS from all its boundary cells
    // Traverse only to neighboring cells with height >= current cell (to simulate reverse flow)
// Traverse Pacific border
    // Left column and top row
// Traverse Atlantic border
    // Right column and bottom row
// After both DFS runs, check all cells
    // If a cell is reachable from both oceans, include it in the result

// Time: O(m*n)
// Space: O(m*n)