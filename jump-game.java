// https://leetcode.com/problems/jump-game/

// Java
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--){
            if (i + nums[i] >= goal) goal = i;
        }

        return goal == 0;
    }
}

// Thought process for solving the Jump Game problem:
//
// // Goal is to determine if you can reach the last index starting from index 0.
// // nums[i] tells you the max jump length from index i.
// // Instead of exploring all paths, we use a greedy strategy.
// // Start from the end and move backward, keeping track of the "goal" index we need to reach.
// // At each index, check if you can jump to or past the current goal: i + nums[i] >= goal.
// // If yes, move the goal to this index.
// // If by the end, goal has moved to 0, it means we can reach the last index from the start.
