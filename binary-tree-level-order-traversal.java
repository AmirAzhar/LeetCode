// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// Java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }
    private void traverse(TreeNode root, List<List<Integer>> nodes, int level) {
        if (root == null) return;
        if (level >= nodes.size()) nodes.add(new ArrayList<>());
        nodes.get(level).add(root.val);
        traverse(root.left, nodes, level + 1);
        traverse(root.right, nodes, level + 1);
    }
}

// JS
var levelOrder = function(root) {

    function traverse(node, level){
        if (!node) return

        if (res.length === level) res.push([]);
        res[level].push(node.val)

        traverse(node.left, level + 1)
        traverse(node.right, level + 1)
    }

    let res = []
    traverse(root, 0)
    return res
    
};

// can use bfs and dfs
// keep track of the level when u process the node
// append to the ith array in the res array
    // ith array represents the nodes in level i of the tree
