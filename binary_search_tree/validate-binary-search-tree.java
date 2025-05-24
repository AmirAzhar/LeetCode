// https://leetcode.com/problems/validate-binary-search-tree/description/

// JS
var isValidBST = function(root) {

    const validate = (root, min, max) => {
        // null root is valid
        if (!root) return true;

        // check within bounds
        if (root.val <= min || root.val >= max) return false

        // check children
        return validate(root.left, min, root.val) && validate(root.right, root.val, max)
    }

    return validate(root, -Infinity, Infinity)
};

// Java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}