// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

// Java
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        // trying to converge to a last element
        while (l < r) {
            int mid = (l + r) / 2;

            // right side
            if (nums[mid] > nums[r]) l = mid + 1;

            // left side
            else r = mid;
        }

        return nums[l];
    }
}