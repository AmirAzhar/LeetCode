// 167. Two Sum II - Input Array Is Sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

package multiple_pointers;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int currSum = numbers[left] + numbers[right];

            if (currSum > target)
                right--;
            else if (currSum < target)
                left++;
            else
                return new int[] { left + 1, right + 1 };

        }
        return null;
    }
}

// two pointers - 1 at the start and 1 at the end
// if the sum is larger than the target, move the right pointer to the left
// if the sum is smaller than the target, move the left pointer to the right
// return the index once target is found