// https://leetcode.com/problems/container-with-most-water/

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
  let res = 0,
    l = 0,
    r = height.length - 1;

  while (l < r) {
    res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
    height[l] < height[r] ? l++ : r--;
  }

  return res;
};

// Time: O(n) -> passing through the array once
// Space O(1) -> just simple variables

// i need to find a pair of walls that has the greatest area
// area = width * height
// height = min(height[l], height[r])
// width = (r - l)
// init a max of 0
// essentially have 2 pointers r and l
// i move the pointer for whichever height is lower
// i keep going until the width is 0 i.e. l and r overlap
