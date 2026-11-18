# https://leetcode.com/problems/flood-fill/

class Solution:
    def floodFill(self, image: list[list[int]], sr: int, sc: int, color: int) -> list[list[int]]:

        start = image[sr][sc]
        dirs = [(0,1), (0,-1), (-1,0), (1,0)]
        rows, cols = len(image), len(image[0])

        if image[sr][sc] == color:
            return image

        def bfs():
            q = deque([(sr, sc)])
            image[sr][sc] = color

            while q:
                r, c = q.popleft()

                for dr, dc in dirs:
                    newR = r + dr
                    newC = c + dc

                    if 0 <= newR < rows and 0 <= newC < cols and image[newR][newC] == start:
                        image[newR][newC] = color
                        q.append((newR, newC))


        def iterative_dfs():
            stack = [(sr, sc)]
            image[sr][sc] = color

            while stack:
                # change current to color
                [r, c] = stack.pop()
                
                # look all 4 directions and add to stack if same color
                for dr, dc in dirs:
                    newR = r + dr
                    newC = c + dc
                    if newR >= 0 and newR < rows and newC >= 0 and newC < cols and image[newR][newC] == start:
                        image[newR][newC] = color
                        stack.append((newR, newC))



        def dfs(r: int, c: int) -> None:
            # change current to color
            image[r][c] = color

            # look all 4 directions and add to stack if same color
            for dr, dc in dirs:
                newR = r + dr
                newC = c + dc
            if newR >= 0 and newR < rows and newC >= 0 and newC < cols and image[newR][newC] == start:
                dfs(newR, newC)

            
        # bfs()
        iterative_dfs()
        # dfs(sr, sc)

        return image
        

# given i need to see "how far" i can reach given any point to find anything connected, i need do some sort of bfs or dfs

# bfs (queue)
# mainatin a FIFO queue that keeps track of all cells that needs to be updated
# i need check 4 dirs (within bounds and same color), and add to teh queue
# keep doing until q empty# used more for shartest path / smallest moves kind of qn

# iterative dfs (stack) 
# maintaoin a LIFO stack that keeps track of all cells that needs to be updated
# i need check 4 dirs (within bounds and same color), and add to teh stack
# keep doing until stack empty

# dfs (recursive)
# i need to set teh curr to the new color
# go through all directions similar to bfs, and call teh function again
# last level would just return
# can be dangerous, hitting recursion limit

# Time: O(m*n) - worst case, all cells are connected and visited once
# Space: O(m*n) - worst case, queue/stack/recursion uses O(m*n) space