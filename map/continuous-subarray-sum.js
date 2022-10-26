// 523. Continuous Subarray Sum
// https://leetcode.com/problems/continuous-subarray-sum/description/

var checkSubarraySum = function (nums, k) {
  // Base Case: If we dont have at least 2 elements, immediately return false
  if (nums.length < 2) return false;

  // We need a map where the key is the prefix sum and the value is the index of the last number added to that sum
  const memo = new Map();
  // Base Case: First element is already a multiple, but by right it should not return true since we need >=2 elements
  memo.set(0, -1);

  // Keep track of the preSum (modulo) for a given number in the array
  let preSum = 0;

  for (let i = 0; i < nums.length; i++) {
    // Add the current num to the sum
    preSum += nums[i];

    // For the sum to be a multiple of k, modulo has to be 0
    preSum %= k;

    // if the presum exists, it means that we found our answer, but we need to check if they at least 2 numbers
    if (i - memo.get(preSum) >= 2) return true;
    // if preSum doesnt exist in the memo, add it in
    else if (!memo.has(preSum)) memo.set(preSum, i);
  }
  return false;
};
