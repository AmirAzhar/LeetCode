// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// Java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
    
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = q.size();

            while (len > 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                len--;
            }

            res.add(level);
        }

        return res;
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

// for level order, you would usually do bfs
// bfs implemented in a queue
// ill first init an empty arraylist to store every thing
// then i init a queue with only the root
// ill take the length of the queue
// while the length is not 0
    // add the value to an arraylist
    // add left to queue if not null
    // add right to queue if not null
