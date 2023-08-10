// 1. Two Sum
// https://leetcode.com/problems/two-sum/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  const map = {};

  for (let i = 0; i < nums.length; i++) {
    if (target - nums[i] in map) return [i, map[target - nums[i]]];
    map[nums[i]] = i;
  }
};

// Time: O(n)
// Space: O(n)
// init map where k:v is the element:index
// Iterate through the array
// Check in the map if (target - element) exists in the map
// if exists, we have found the pair
// if doesnt exist, Store each element in a map
