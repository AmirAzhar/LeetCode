# https://leetcode.com/problems/number-of-islands/description/

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        islands = 0
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        rows = len(grid)
        cols = len(grid[0])

        def fillIsland(r: int, c: int):
            grid[r][c] = "0"

            for d in dirs:
                newR = r + d[0]
                newC = c + d[1]

                if newR >= 0 and newR < rows and newC >= 0 and newC < cols and grid[newR][newC] == "1":
                    fillIsland(newR, newC)


        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    fillIsland(r, c)
                    islands += 1
        
        return islands

# we can iterate the whole grid until we find a "1", which will be our starting point for an island
# we want to be bale to explore an island so we can use an algo like dfs and bfs, to find all adjacent "1"
# to show that we visited it, we will turn all the "1" into "0"
# once dfs finishes, means whole island has been explored
# so the main loop will not encounter the same island again
# Time: O(m*n) - scan the entire grid, visiting each cell at most once.
# Space: O(m*n) - worst case, the recursive DFS stack can contain
#        up to m*n calls if the entire grid is one connected island.
