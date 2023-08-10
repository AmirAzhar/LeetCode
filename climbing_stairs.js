/**
 * @param {number} n
 * @return {number}
 */

 // Time: O(n)
 var climbStairs_iterative = function(n) {
  let first = 1, second = 1, temp

  for (let i = 0; i < n-1 ; i++){
      temp = first
      first += second
      second = temp
  }

  return first
};

// Time: O(2^n)
var climbStairs_recursive = function(n) {
  if (n == 1 || n == 0) return 1
  if (n == 2) return 2

  return climbStairs_recursive(n-1) + climbStairs_recursive(n-2)
};

// Time: O(n)
var climbStairs_memo = function(n, memo = {1:1, 2:2}) {
 if (n in memo) return memo[n];   
 memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
 return memo[n];
};

var climbStairs = function(n) {
  // return climbStairs_iterative(n)
  // return climbStairs_recursive(n)
  return climbStairs_memo(n)
}