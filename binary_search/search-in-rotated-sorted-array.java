// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

// Java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // we do left < right with no = because we are trying to get left and right to converge to an index
        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) left = mid + 1; // pivot is on the right side, incremenet because mid cannot be the pivot itself
            else right = mid; // pivot is on the left side, dont increment as mid may still be a pivot itself
        }

        // at this point, left == right
        int pivot = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[pivot] && target <= nums[right]) left = pivot; // target in right side
        else right = pivot - 1; // target in left side
        

        // we also check = because we want to check every possible element to see if it satisfies a condition
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}

// given the constraint that it must be done in logn, i am thinking that i need to perform some kind of binary search
// i cant do traditional bin search because the array has already been rotated
// i can maybe use binary search to find the pivot point first

// then anothrer binary search to find the target on either the left or right half