// https://leetcode.com/problems/house-robber/submissions/1526181041/

// Java
class Solution {
    public int rob(int[] nums) {
        int prev = 0, prev2 = 0;
    
        for (int num : nums){
            int temp = Math.max(prev, prev2 + num);
            prev2 = prev;
            prev = temp;
        }

        return prev;
    }
}

// JS
var rob = function(nums) {
    let prev = 0, 
        prev2 = 0 
    
    for (const num of nums){
        let temp = Math.max(prev, prev2 + num)
        prev2 = prev
        prev = temp
    }
    return prev
};

// Thought process for solving the House Robber problem:
//
// // Can't rob two adjacent houses — need to decide at each house: rob or skip.
// // Defined subproblem: let rob(i) be the max money robbed up to house i.
// // Recurrence relation: rob(i) = max(rob(i-1), rob(i-2) + nums[i])
// // This means: either skip current house, or rob it and add it to total from two houses back.
// // Used iteration instead of recursion to avoid stack overhead and simplify code.
// // Tracked only two previous results using variables: prev1 (i-1), prev2 (i-2).
// // Initialized prev1 = 0 and prev2 = 0, since no money before the first house.
// // In each iteration, calculated current = max(prev1, prev2 + num)
// // Then updated prev2 = prev1, prev1 = current for next step.
// // After processing all houses, prev1 holds the maximum money that can be robbed.
