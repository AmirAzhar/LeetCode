// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

// Java
class Solution {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        createParentMap(root, null);
        return bfsFromTarget(target, k);
    }

    private void createParentMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (parent != null) parentMap.put(node, parent);
        createParentMap(node.left, node);
        createParentMap(node.right, node);
    }

    private List<Integer> bfsFromTarget(TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        q.offer(target);
        visited.add(target);

        while (!q.isEmpty() && k >= 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (k == 0) res.add(node.val);

                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }

                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.offer(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.offer(node.right);
                }
            }
            k--;
        }

        return res;
    }
}


// in a tree, it is easy to go downward but not upward
// to easily traverse upward i need to use a map such that
    // k is the node
    // v is the paent

// then i perform bfs starting from the target node
    // similar to level order, we need go layer by layer until k reaches 0
    // we go to its children and also its parent using the parentmap
    // add them to the queue and the visited set
    // once k == 1, whatever is in the queue is the nodes k distance away