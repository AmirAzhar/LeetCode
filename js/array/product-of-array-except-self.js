// https://leetcode.com/problems/product-of-array-except-self/

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function (nums) {
  let res = [];

  let prod = 1;
  for (let i = 0; i < nums.length; i++) {
    res[i] = prod;
    prod *= nums[i];
  }

  prod = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    res[i] *= prod;
    prod *= nums[i];
  }

  return res;
};

// Time: O(n) -> linear array iteration
// Space: O(n) -> result array

// brute force would be double for loop, for each element, multiply by every other element but that would be O(n^2)
// there is alot of recomputation
// instead we can
// get product of everything to the left of the element (leftmost should be 1)
// get product of everything to the right of the element (rightmost should be 1)
// then we can multiple them
