//https://leetcode.com/problems/binary-tree-right-side-view/description/

// Java
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();

//         if (root == null) return res;

//         q.offer(root);

//         while (!q.isEmpty()) {
//             int len = q.size();

//             while (len > 0) {
//                 TreeNode node = q.poll();
//                 if (len == 1) res.add(node.val);
//                 if (node.left != null) q.offer(node.left);
//                 if (node.right != null) q.offer(node.right);
//                 len--;
//             }
//         }

//         return res;
//     }
// }

public class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        rightView(root, 0);

        return res;
    }
    
    public void rightView(TreeNode curr, int level){
        if (curr == null) return;
        
        if (level == res.size()) res.add(curr.val);

        rightView(curr.right, level + 1);
        rightView(curr.left, level + 1);
    }
}

// i will do a level order traversal
// take the last element of the level to put in res

// i can do dfs also
// where i visit the right first then left
// the first node i see at each level should be the rightmost
    // can do this by checking if the level == size of res