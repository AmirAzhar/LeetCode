// 278. First Bad Version
// https://leetcode.com/problems/first-bad-version

/**
 * @param {function} isBadVersion()
 * @return {function}
 */
var solution = function (isBadVersion) {
  /**
   * @param {integer} n Total versions
   * @return {integer} The first bad version
   */
  return function (n) {
    let left = 1,
      right = n,
      res = n,
      mid;

    while (left <= right) {
      mid = left + Math.floor((right - left) / 2);
      if (isBadVersion(mid)) {
        res = mid;
        right = mid - 1;
      } else left = mid + 1;
    }

    return res;
  };
};

// Time O(logn)
// Space: O(1)
// we can technically do a linear search but since we need to minimise API calls, use binary search since it is sorted
// very similar to the pivot point problem
// start by using 2 pointers that point to the start and end of the array
// create a mid pointer that points to the middle of the array
// if mid is bad, we upodate the res BUT continue searching on the left side for the MOST LEFT bad version
// if mid is not bad, we need to search on the right side

// we use left + Math.floor((right - left) / 2) instead of Math.floor((right + left) / 2) in case right + left results in overflow
