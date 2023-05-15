// 2635. Apply Transform Over Each Element in Array
// https://leetcode.com/problems/apply-transform-over-each-element-in-array/description/?utm_campaign=PostD4&utm_medium=Post&utm_source=Post&gio_link_id=noqbNOv9

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function (arr, fn) {
  for (let i = 0; i < arr.length; i++) arr[i] = fn(arr[i], i);
  return arr;
};
