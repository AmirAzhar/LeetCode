// 645. Set Mismatch
// https://leetcode.com/problems/set-mismatch/

var findErrorNums = function (nums) {
  let N = nums.length,
    sum = (N * (N + 1)) / 2,
    seen = {},
    duplicate;

  for (const num of nums) {
    sum -= num;
    if (num in seen) duplicate = num;
    seen[num] = true;
  }

  return [duplicate, sum + duplicate];
};
