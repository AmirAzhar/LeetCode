// 16. 3Sum Closest
// https://leetcode.com/problems/3sum-closest/description/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target) {
  // Res to keep track of the lowest sum so far, and lowestDiff to keep track of |target - res|
  let res = 0,
    lowestDiff = Number.MAX_SAFE_INTEGER;

  // Need to sort in ascending first to do a search
  nums = nums.sort((a, b) => a - b);

  for (let i = 0; i < nums.length; i++) {
    // init left and right pointers
    let left = i + 1,
      right = nums.length - 1;

    while (left < right) {
      // Get the current sum of the 3 numbers and its diff from the target
      let sum = nums[i] + nums[left] + nums[right];
      let diff = Math.abs(sum - target);

      // Update the res and lowestDiff if the current triplet is a better result
      if (diff < lowestDiff) {
        lowestDiff = diff;
        res = sum;
      }
      // If the sum is already hit, the triplet is alr the best option, so return
      if (sum === target) return target;
      // If the sum is not hit, then update the pointers
      else if (sum > target) right--;
      else left++;
    }
  }
  return res;
};
