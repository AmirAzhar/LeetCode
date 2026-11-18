// https://leetcode.com/problems/01-matrix/submissions/1564472923/

// Java
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        // Init the res
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (mat[r][c] == 0) q.offer(new int[]{r, c}); // add to queue for bfs
                else mat[r][c] = Integer.MAX_VALUE;
            }
        }

        // bfs
        while (!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : dirs){
                int newX = cell[0] + dir[0];
                int newY = cell[1] + dir[1];

                // check within bounds
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols) {

                    // check if it has already been traversed
                    if (mat[newX][newY] == Integer.MAX_VALUE){
                        mat[newX][newY] = mat[x][y] + 1;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }


        }

        return mat;
    }
}

// JS
var updateMatrix = function(mat) {
    let rows = mat.length;
    let cols = mat[0].length;
    let q = [];
    let dirs = [[0,1], [1,0], [-1,0], [0,-1]]

    for (let r = 0; r < rows; r++){
        for (let c = 0; c < cols; c++){
            if (mat[r][c]) mat[r][c] = Infinity;
            else q.push([r, c]);
        }
    }

    while (q.length){
        let [x, y] = q.shift();

        for (const d of dirs){
            let newX = x + d[0];
            let newY = y + d[1];

            if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && mat[newX][newY] == Infinity){
                mat[newX][newY] = mat[x][y] + 1;
                q.push([newX, newY]);
            }
        }
    }

    return mat;
};


// the distance of the nearest 0 for a cell is the min(up, down, left, right) + 1 -> so technically BFS because we want find shortest path
// init a res
    // all 0s have a dstance of 0 so thats the start
    // the rest should be MAX_VALUE
// then we do a multi source bfs
    // init a queue so that it starts from all 0s at once
// while the wueue in not empty
    // edxplore the neighbours and update the value