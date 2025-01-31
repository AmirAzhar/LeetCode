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

// for each house, which is better
    // Skip this house and keep what we had before (prev)
    // Rob this house and add it to what we had two houses ago (prev2 + num)
// int temp = Math.max(prev, prev2 + num) -> chooses between the above 2 options