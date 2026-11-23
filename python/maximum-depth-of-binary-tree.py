# https://leetcode.com/problems/maximum-depth-of-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: TreeNode | None) -> int:
        if root is None:
            return 0

        # stack = [(root, 1)]
        # res = 0

        # while stack:
        #     curr, depth = stack.pop()
        #     res = max(res, depth)

        #     if curr.left:
        #         stack.append((curr.left, depth + 1))

        #     if curr.right:
        #         stack.append((curr.right, depth + 1))

        # return res

        return 1 + max(
            self.maxDepth(root.left), 
            self.maxDepth(root.right)
        )



# We use iterative DFS with a stack to find the maximum depth.
# Each stack entry stores the current node and its depth.
#
# We start with the root at depth 1.
# For each node, we update the maximum depth encountered so far.
# We then add its children to the stack, incrementing their depth by 1.
#
# We continue until the stack is empty, meaning all nodes have been visited.
# Finally, we return the maximum depth recorded.
#
# Time: O(n) - every node is visited once.
# Space: O(h) - stack size depends on the height of the tree.
#   Balanced tree: O(log n)
#   Skewed tree: O(n)

# simpler, and easeir to visualize breaking down of subproblems
# We use recursive DFS by breaking the problem into smaller subproblems.
# The maximum depth of a tree is 1 plus the maximum depth of its subtrees.
#
# Our base case is when the current node is None, where we return 0.
# Otherwise, we recursively calculate the depth of the left and right subtrees.
# We take the larger depth and add 1 to account for the current node.
#
# This continues until all recursive calls return their depths,
# giving us the maximum depth of the entire tree.
#
# Time: O(n) - every node is visited once.
# Space: O(h) - recursion stack depends on tree height.
#   Balanced tree: O(log n)
#   Skewed tree: O(n)