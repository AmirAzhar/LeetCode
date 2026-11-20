# https://leetcode.com/problems/invert-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: TreeNode | None) -> TreeNode | None:
        def invert(root: TreeNode | None):

            if root is None:
                return None

            root.left, root.right = root.right, root.left

            invert(root.left)
            invert(root.right)
        
        invert(root)

        return root

# breaking down into subproblems, i basically need to go to each parent node, and swap the child
# i need to perform this recursively, and this stops when the node is null 
# Time: O(n) - Every node is visited exactly once, and swapping its children takes O(1) time.
# Space: O(n) - The recursive call stack depends on the height of the tree, recursion stack only contains the nodes along the current path from the root.