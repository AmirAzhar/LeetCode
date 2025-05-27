// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// Java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q), right = lowestCommonAncestor(root.right, p, q); 

        if (left != null && right != null) return root;
        
        return left == null ? right : left;
    }
}

// Okay, I need to return the lowest node in the tree such that both p and q are descendants of it. 
// This includes the possibility of a node being a descendant of itself.
// at each node you want to ask
    // do i see p in the left subtree
    // do i see q in the right subtree
    // if i find both, then the root is the LCA
// each return is like a bubble going up, and im trying to find a node where it gets a bubble from both left and right
// if i only have a bubble from the left, then i bubble that up
// if i only have a bubble from the right, then i bubble that up
// our base case is what creates the bubble
    // if null, means we havent found p or q -> then return null which is no bubble
    // if not, we return p/q as a bubble