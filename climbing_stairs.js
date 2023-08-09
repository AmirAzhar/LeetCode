// 70. Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/

/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
  let first = 1,
    second = 1,
    temp;

  for (let i = 0; i < n - 1; i++) {
    temp = first;
    first += second;
    second = temp;
  }

  return first;
};
