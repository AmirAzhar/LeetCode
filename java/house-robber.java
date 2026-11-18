// https://leetcode.com/problems/house-robber/

// Java
class Solution {
    public int rob(int[] nums) {
        int prev1 = 0, prev2 = 0;

        for (int num : nums) {
            int curr = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
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

// at every house you have a choice to rob a house or not
// What gives us more money — skipping this house and keeping what we had, or robbing this house and adding its value to the best we could get two houses ago
// so we need to track the max value at the prev house, and prev prev house
// at any house we can either 
    // not rob and keep what we already have from the prev house - prev1
    // rob and add on to what we had in the prev prev house - prev2 + num
// return prev1 because that is the max value at the last ele
