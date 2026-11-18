// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

// Java
class Solution {
    private int result = -1;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {

        inOrderTraversal(root, k);

        return result;
    }

    private void inOrderTraversal(TreeNode root, int k) {
        if (root == null) return;

        inOrderTraversal(root.left, k);

        count++;
        if (k == count) {
            result = root.val;
            return;
        }
        
        inOrderTraversal(root.right, k);
    }
}

// i can perform in orer traversal
    // left
    // itself
    // right
// this will definitely return me in ascending order
// i will check agaisnt a count value
    // check against k to se if we reach the desired smallest element