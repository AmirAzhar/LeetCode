// 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Create a res array
        int[] res = new int[nums.length];

        // Calculate the prefix product (product of all numbers before itself) in place
        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            pre *= nums[i];
        }

        // Calculate the postfix product (product of all numbers after itself) in place,
        // and multiply with the prev calculated prefix values
        int post = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= post;
            post *= nums[i];
        }

        return res;
    }
}