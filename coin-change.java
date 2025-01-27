// https://leetcode.com/problems/coin-change/

// Java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0; 

        for (int c : coins) {
            for (int x = c; x <= amount; x++) { 
                if (memo[x - c] != Integer.MAX_VALUE) { 
                    memo[x] = Math.min(memo[x], memo[x - c] + 1);
                }
            }
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}


// JS
var coinChange = function(coins, amount) {
    let dp = Array(amount + 1).fill(Infinity);
    dp[0] = 0;

    for (let coin of coins) {
        for (let x = coin; x <= amount; x++) {
            dp[x] = Math.min(dp[x], dp[x - coin] + 1);
        }
    }

    return dp[amount] === Infinity ? -1 : dp[amount];
};
// To find the minimum number of coins needed for amount, 
    // we break it down into smaller amounts (amount - coin). 
    // For example, if we use a coin of value c, the remaining problem is to solve for amount - c.
    // dp[x] = min(dp[x], dp[x−c]+1)

// We use a dynamic programming array `dp` where `dp[x]` represents the minimum coins needed to make amount `x`.
// Initialize `dp` with `Infinity`, except `dp[0] = 0` because no coins are needed to make amount 0.
// For each coin, iterate through all amounts from `coin` to `amount`. Update `dp[x]` as the minimum between its current value and `dp[x - coin] + 1`.
// If `dp[amount]` remains `Infinity`, the amount cannot be formed, so return -1. Otherwise, return `dp[amount]`, the minimum coins needed.