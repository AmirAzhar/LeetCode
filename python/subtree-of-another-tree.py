# https://leetcode.com/problems/subtree-of-another-tree/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: TreeNode | None, subRoot: TreeNode | None) -> bool:

        def isSameTree(r1: TreeNode | None, r2: TreeNode | None) -> bool:
            if r1 is None and r2 is None:
                return True
            if r1 is None or r2 is None:
                return False
            if r1.val != r2.val:
                return False

            return isSameTree(r1.left, r2.left) and isSameTree(r1.right, r2.right)

        if subRoot is None:
            return True
        
        if root is None:
            return False
        
        if isSameTree(root, subRoot):
            return True

        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

# We use recursive DFS to check if subRoot exists within root.
# We break the problem into two smaller problems:
# 1. Check whether two trees are exactly identical.
# 2. Search through root to find a subtree that matches subRoot.
#
# For the identical-tree check:
# - If both nodes are None, return True.
# - If only one is None or their values differ, return False.
# - Otherwise, recursively compare their left and right subtrees.
# - Both subtrees must match for the trees to be identical.
#
# For the subtree search:
# - At each node, check whether the current tree matches subRoot.
# - If it matches, return True immediately.
# - Otherwise, recursively search the left and right subtrees.
# - If neither subtree contains a match, return False.
#
# Time: O(n*m) - worst case, compare up to m nodes at each of n nodes.
# Space: O(h1+h2) - recursion stacks depend on the heights of both trees.
#
# Further optimization:
# We can improve the time complexity to O(n+m) using tree serialization + KMP.
# First, serialize both trees using preorder DFS, including None markers
# to preserve their structure.
# Then use KMP (Knuth-Morris-Pratt) to search for the serialized subRoot
# within the serialized root.
# KMP uses an LPS (Longest Prefix Suffix) array to avoid repeating
# comparisons when a partial match fails.
# Time: O(n+m) - linear serialization and pattern matching.
# Space: O(n+m) - serialized trees and LPS array.