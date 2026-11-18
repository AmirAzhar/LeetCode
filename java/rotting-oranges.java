// https://leetcode.com/problems/rotting-oranges/description/

// Java
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 2) queue.offer(new int[]{r, c});
                else if (grid[r][c] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int steps = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            boolean isRotten = false;

            for (int i = 0; i < size; i++){
                int[] cell = queue.poll();
                
                for (int[] d : dirs) {
                    int newR = cell[0] + d[0];
                    int newC = cell[1] + d[1];

                    if (newR >= 0 && newC >= 0 && newR < rows && newC < cols && grid[newR][newC] == 1){
                        grid[newR][newC] = 2;
                        queue.offer(new int[]{newR, newC});
                        fresh--;
                        isRotten = true;
                    }
                }
            }

            if (isRotten) steps++;
        }

        return fresh > 0 ? -1 : steps;
        
    }
}

// more than 1 starting point, so i will use a multi source bfs
// to setup, i need to iterate through the grid  
    // add any rotten cells to the queue
    // count the number of fresh oranges
// while the queue is not empty
    // iterate through level by level (based on the size of the current queue)
        // check all directions to see if there are any oranges to spread to
        // if there are, rot it, decrement the fresh count, add to queue
    // if the level has rotted something, then the count of steps should go up 