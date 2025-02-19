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