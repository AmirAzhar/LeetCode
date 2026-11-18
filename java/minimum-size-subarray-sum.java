// https://leetcode.com/problems/minimum-size-subarray-sum/

// Java

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int res = Integer.MAX_VALUE, curr = 0;

        while (r < nums.length){
            curr += nums[r];
            while (curr >= target){
                res = Math.min(res, r - l + 1);
                curr -= nums[l];
                l++;
            }
            r++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// i will use a sliding window technique
    // l will keep track fo the start fo subarray
    // r will keep track of the end of subarray
// as i move l and r, i will update the curr
// if curr >= max, will also update max
// add the right pointer
// while the curr sum is more than the target
    // reduce by left pointer
    // update the length