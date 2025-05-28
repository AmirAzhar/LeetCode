// https://leetcode.com/problems/maximum-width-of-binary-tree/description/

// java
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minId = q.peek().id;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int id = p.id - minId; // we need to normalise

                if (i == 0) first = id;
                if (i == size - 1) last = id;

                if (p.node.left != null) q.offer(new Pair(p.node.left, 2 * id));
                if (p.node.right != null) q.offer(new Pair(p.node.right, 2 * id + 1));
            }

            res = Math.max(res, last - first + 1);
        }

        return res;
    }

    class Pair {
        TreeNode node;
        int id;

        public Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }
}




// i can give each node some sort of index
// if we were to number the nodes, with the root starting at 1
    // left child -> 2i
    // right child -> 2i + 1
    
// in eg 1
// 1
// 2 3
// 4 5 null 7

// what i can do now is some sort of level order traversal
// at the end of each level, i take the max - min
// we dont need an array list to store all the indexes
// we can simply just take the first and last indexes while we iterate
// we need to also normalise the index
    // lets say in a level we have the indices [1048576, 1048578, 1048580]
    // if we simply perform the index frormula from this, will overflow
    // so we can normalize it to [0, 2, 4]
        // done by taking what the minid is -> taking that as 0