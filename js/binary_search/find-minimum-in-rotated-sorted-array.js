// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

/**
 * @param {number[]} nums
 * @return {number}
 */
// var findMin = function(nums) {
//     if (nums[nums.length - 1] > nums[0]) return nums[0];

//     let l = 0, r = nums.length - 1;

//     while (l < r) {
//         let m = Math.floor((l + r) / 2);

//         if (nums[m] >= nums[0]) l = m + 1;
//         else r = m;
//     }

//     return nums[l];
// };

var findMin = function (nums) {
  let l = 0,
    r = nums.length - 1;

  while (l < r) {
    let m = Math.floor((l + r) / 2);
    if (nums[m] > nums[r]) l = m + 1;
    else r = m;
  }

  return nums[l];
};

// Time: O(log n) -> binary search always halves the search area
// Space: O(1)

// when i see O(log n), i immediately think of binary search
// since it is rotated, i cant immediately perform traditional binary search
// i need to think of a diff clause for binary search
// given the curr chosen num at m nums[m]
// if nums[m] >= nums[0]
// it means that res should be on the right side
// update l = m + 1
// why >= ? because if theres any equal element, we still treat it as left
// if nums[m] < nums[0]
// it means thet res should be on the left side
// update r = m
// why not m-1? because m might be the minimum itself
// corner case if it still sorted
// nums[nums.length - 1] > nums[0]
// return nums[0]

// OR instaed of comparing with the nums[0] -> we can compare with nums[r]
// if nums[m] > nums[r]
// then the minimum is to the right of m.
// else
// to the left
// in this case, we dont need to do special case handling
