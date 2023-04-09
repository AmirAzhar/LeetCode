// 104. Maximum Depth of Binary Tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

package binary_tree;

class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);

    }
}
