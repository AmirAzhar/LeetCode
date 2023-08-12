// 169. Majority Element
// https://leetcode.com/problems/majority-element/

/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
  let count = 0,
    res = null;

  for (const num of nums) {
    if (count == 0) {
      count++;
      res = num;
    } else if (num == res) count++;
    else count--;
  }
  return res;
};

// TIme: O(n)
// Space O(1)
// Boyer–Moore majority vote algorithm: https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
// Assume we have a sequence of size N that has a majority element m. It can be shown by way of negation that the algorithm can't output a non majority element.

// The algorithm chooses the first element in the sequence as the majority candidate c and initializes a counter for that candidate with value 1. If the candidate is not the majority element, then the counter must reach zero since there are more elements in the sequence that are not equal to the candidate. When the counter reaches zero after K < N iterations, then we consumed exactly K / 2 elements with the candidate value (K must be even). Whether the candidate equals to the majority element m or not, we are left with a subsequence of length N - K where m is still the majority element.
