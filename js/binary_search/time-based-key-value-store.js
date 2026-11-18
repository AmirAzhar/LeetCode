// https://leetcode.com/problems/time-based-key-value-store/description/

var TimeMap = function () {
  this.map = new Map();
};

TimeMap.prototype.set = function (key, value, timestamp) {
  const arr = this.map.get(key) || [];
  arr.push([timestamp, value]);
  this.map.set(key, arr);
};

TimeMap.prototype.get = function (key, timestamp) {
  const arr = this.map.get(key);

  if (!arr) return "";

  let l = 0,
    r = arr.length - 1,
    res = "";

  while (l <= r) {
    const m = Math.floor((l + r) / 2);
    if (arr[m][0] <= timestamp) {
      res = arr[m][1];
      l = m + 1;
    } else r = m - 1;
  }

  return res;
};

// key can have multiple values that has timestamp
// i can use a map
// key -> simply a key string e.g. foo
// value -> array of pair <timestamp, val> e.g [[1, bar], [4, bar2]]
// for setting
// i can assume that the set calls come with non-decreasing timestamps per key.
// in this case i dont always ned tp sort / binary search top insert
// i can safely push to the end of the list -> it will always be sorted
// for getting
// we can perform a modified traditional binary search
// since we want to find the value that has the largest timsetamp that is < than the input timestemap
// there wont be an early return, we will update the res, whenever we find a timestamp lesser than input, but we will continue looking on the right side for anymore higher timestamp
