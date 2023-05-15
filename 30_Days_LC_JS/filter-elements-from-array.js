// 2634. Filter Elements from Array
// https://leetcode.com/problems/filter-elements-from-array/description/?utm_campaign=PostD5&utm_medium=Post&utm_source=Post&gio_link_id=a9a5VZr9

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function (arr, fn) {
  const res = [];
  for (let i = 0; i < arr.length; i++) if (fn(arr[i], i)) res.push(arr[i]);
  return res;
};
