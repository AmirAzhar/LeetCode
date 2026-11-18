// https://leetcode.com/problems/coin-change/

// Java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int c : coins) {
            for (int curr = c; curr <= amount; curr++) {
                dp[curr] = Math.min(dp[curr], dp[curr - c] + 1);
            }
        }

        return dp[amount] == amount + 1? -1 : dp[amount];

    }
}

// JS
var coinChange = function(coins, amount) {
    let dp = Array(amount + 1).fill(amount + 1);
    dp[0] = 0;

    for (let coin of coins) {
        for (let currAmount = coin; currAmount <= amount; currAmount++) {
            dp[currAmount] = Math.min(dp[currAmount], dp[currAmount - coin] + 1);
        }
    }

    return dp[amount] === amount + 1 ? -1 : dp[amount];
};

// this problem can be represented as a tree problem, 
    // node is the remaining value
    // each path is a coin chosen to reduce the path
// but there will be repeated calculations -> sub-branches that have the same remaining values that have already been calculated
// so we can try to use dp to store previously calculated values
    // dp[i] is the min coins required to reach i
// we can do a bottom up approach, bascially starting from the smallest values of coins and working our way up to the amount
// we will try using each coin see how it affects every reachable amount.
// if I use coin c, can I make curr with fewer coins than before?