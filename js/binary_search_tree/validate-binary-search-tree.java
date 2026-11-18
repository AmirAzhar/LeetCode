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

    private boolean validate (TreeNode root, long min, long max) {
        // base case
        if (root == null) return true;

        // check if values are valid
        if (root.val <= min || root.val >= max) return false;

        // validate left and right
        return validate(root.left, min, root.val) && validate(root.right,  root.val, max);
    }
}


// for a BST to be valid, left subtree and right subtree needs to be valid as well
    // so we are thinking of a recursive solution
// but we need to ensure that 
    // ALL ele to the left subtree is smaller than the node
    // ALL ele to the right subtree is bigger than the node
// our recursive function needs to have a way to keep track of what is the min and max value a node can have
// at first, the min and max will be inifity
    // when we traverse left, the max will be update to be the root.val
    // when we traverse right, the min will update to be the root.val