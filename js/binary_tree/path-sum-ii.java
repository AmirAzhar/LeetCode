// https://leetcode.com/problems/path-sum-ii/description/

// Java
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> path) {
        if (node == null) return;

        // Add current node to the path
        path.add(node.val);

        // Check if it's a leaf and the path sum matches
        if (node.left == null && node.right == null && remainingSum == node.val) {
            res.add(new ArrayList<>(path));  // Make a copy
        }

        // Recurse
        dfs(node.left, remainingSum - node.val, path);
        dfs(node.right, remainingSum - node.val, path);

        // Backtrack
        path.remove(path.size() - 1);
    }
}

// i will perform dfs + a path array that keps track of the current path
// when i reach the leaf node
    // i check what is the remianing sum == 0
    // if it is, then i add to the res
// we also need to backtrack, backtrack usually happens in the following way
    // choose path/decision - path.add(choice)
    // make recrseive calls based on that decision - dfs(next_state)
    // backtrack/undo the choice - path.remove(path.size - 1)