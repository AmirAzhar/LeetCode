// 2626. Array Reduce Transformation
// https://leetcode.com/problems/array-reduce-transformation/description/

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function (nums, fn, init) {
  let val = init;
  for (const num of nums) val = fn(val, num);
  return val;
};
