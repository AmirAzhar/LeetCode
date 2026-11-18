// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
  let l = 0,
    r = nums.length - 1;

  while (l < r) {
    let m = Math.floor((l + r) / 2);

    if (nums[m] > nums[r]) l = m + 1;
    else r = m;
  }

  const rotation = l;
  l = 0;
  r = nums.length - 1;

  if (target >= nums[rotation] && target <= nums[nums.length - 1]) l = rotation;
  else r = rotation - 1;

  while (l <= r) {
    let m = Math.floor((l + r) / 2);

    if (nums[m] == target) return m;
    else if (target > nums[m]) l = m + 1;
    else r = m - 1;
  }

  return -1;
};

// Time: O(log n) -> since we don binary searcg twice, essentially just O(log n)
// Space: O(1)

// we can do 2 binary searches
// first for finding the rotation point
// second for fidng the target on whichever half
// first binary searcg will be done similar to leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// this will help find the rotation point
// then we need find out which halfthe target belongs to
// check target >= nums[rotation] && target <= nums[nums.length - 1]
// right half
// search from rotation to end
// else
// left half
// search from start to rotation
// do a traditional bs
