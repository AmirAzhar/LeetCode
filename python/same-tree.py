# https://leetcode.com/problems/same-tree/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: TreeNode | None, q: TreeNode | None) -> bool:
        if p is None and q is None:
            return True

        if p is None or q is None:
            return False

        if p.val != q.val:
            return False

        return (
            self.isSameTree(p.left, q.left)
            and self.isSameTree(p.right, q.right)
        )


# we can break it down into subproblems
# to see if a tree is same, we can compare it subtrees
# so we can do this recursively until we hit a leaf node
# the termination conditions should be
     # if both null, reach leaf already so we can safely return true, and clim back up the recursion stack
     # if they are different values (one None) or .val different, fail fast and retun False
# Time: O(n) - worst case go through all the nodes to compare
# Space: O(h) - this is somewhat a recursive DFS, and call stack can be as long as the height of the tree