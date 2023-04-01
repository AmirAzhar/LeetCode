// 724. Find Pivot Index
// https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        int left = 0, right = sum;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            right -= curr;
            if (right == left)
                return i;
            left += curr;
        }
        return -1;
    }
}
