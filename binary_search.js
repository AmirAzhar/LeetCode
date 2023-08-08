// 704. Binary Search
// https://leetcode.com/problems/binary-search/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
  let left = 0,
    right = nums.length - 1,
    mid = 0;

  while (left <= right) {
    mid = left + Math.floor((right - left) / 2);
    if (target == nums[mid]) return mid;
    target > nums[mid] ? (left = mid + 1) : (right = mid - 1);
  }

  return -1;
};

// Time: O(log n)
// Space: O(1)
// we need a searching algo that in O(log n) -> binary search
// since the array is already sorted, we can easily do the search
// init left and right pointers
// while the left <= right pointers, define the mid pointer which is the middle of those 2 pointers
// why is "=" important for the while loop => sample case where there is only one element in the array, left and right are equal
// compare the target with the mid pointer
// if target > mid pointer -> search the right side by moving the left pointer to the right of mid
// if target < mid pointer -> search the left side by moving the right pointer to the left mid
// if mid === target, return
// if reach this point, no result -> return - 1

// we use left + Math.floor((right - left) / 2) instead of Math.floor((right + left) / 2) in case right + left results in overflow
