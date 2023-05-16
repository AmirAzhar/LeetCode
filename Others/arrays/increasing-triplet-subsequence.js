// 334. Increasing Triplet Subsequence
// https://leetcode.com/problems/increasing-triplet-subsequence/description/

var increasingTriplet = function (nums) {
  // Base Case
  if (nums.length < 3) return false;

  let minVal = nums[0],
    middleVal = Number.MAX_SAFE_INTEGER;

  for (const num of nums) {
    if (num <= minVal) minVal = num;
    else if (num <= middleVal) middleVal = num;
    else return true;
  }
  return false;
};
