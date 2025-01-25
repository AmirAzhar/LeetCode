// https://leetcode.com/problems/maximum-subarray/

// Java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++){
            int n = nums[i];
            sum = Math.max(n, sum + n);
            max = Math.max(max, sum);
        }
        
        return max;
        
    }
}

// JS
var maxSubArray = function(nums) {
    let sum = nums[0];
    let max = nums[0];

    for (let i = 1; i < nums.length; i++){
        let n = nums[i];
        sum = Math.max(n, sum + n);
        max = Math.max(max, sum);
    }
        
    return max; 
};


// for any element in the array, there are two possibilities:
    // Start a new subarray with the current element.
    // Extend the previous subarray by including the current element.
// The decision is made by comparing these two options and picking the one that maximizes the sum up to that element.

// iterate through
    // sum = Math.max(nums[i], sum + nums[i])
    // sum is The current element alone (starting a new subarray) OR
    // The current element added to the previous subarray (sum + nums[i]).
    // update max if needed
