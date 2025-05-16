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

// can i reach the goal from somewhere else?
// be greedy - I know how to get from here to the end, so now I just need to check if I can get to here from earlier
// Starting from the end, I check whether each index can jump to or beyond the current goal -> nums[i] + i >= goal
// If it can, I update the goal to that index -> goal = i
// If I can move the goal all the way back to index 0, it means the start can reach the end -> goal == 0
