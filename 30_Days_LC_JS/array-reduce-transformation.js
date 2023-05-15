// 2626. Array Reduce Transformation
// https://leetcode.com/problems/array-reduce-transformation/description/?utm_campaign=PostD6&utm_medium=Post&utm_source=Post&gio_link_id=nPN45jD9

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
