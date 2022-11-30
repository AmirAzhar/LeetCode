// 907. Sum of Subarray Minimums
// https://leetcode.com/problems/sum-of-subarray-minimums/description/

var sumSubarrayMins = function (a) {
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    let small = a[i];
    for (let j = i; j < a.length; j++) {
      small = Math.min(small, a[j]);
      sum += small;
    }
  }

  return sum % (1e9 + 7);
};
