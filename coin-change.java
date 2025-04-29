// https://leetcode.com/problems/coin-change/

// Java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;

        for (int c : coins) {
            for (int currAmount = c; currAmount <= amount; currAmount++) {
                memo[currAmount] = Math.min(memo[currAmount], memo[currAmount - c] + 1);
            }
        }

        return memo[amount] == amount + 1 ? -1 : memo[amount];
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

// Decision tree approach (Top-down memoization): 
// In this approach, imagine you're recursively trying to break down the problem by selecting coins.
// You start with a total amount and recursively decide which coin to pick at each step, reducing the problem size.
// The root of this decision tree is the total amount you're trying to make, and each branch represents picking a coin,
// which leads to a new subproblem (i.e., "make amount - coin chosen"). For example, if you're trying to make `5` and pick `1`, 
// you move to a new subproblem: "make amount 4". This branching continues recursively until you hit the base case (amount == 0).
// The goal is to explore all possible ways of choosing coins, and once you reach the base case, you check how many coins you used.
// In this decision tree, the shortest path (i.e., the fewest coins) is the optimal solution.

// However, this approach leads to **repeated calculations**.
// In top-down recursive solutions, you'll often find yourself recalculating the same subproblems multiple times. 
// For example, when solving for amount 5, you might recompute the solution for amount 3 and amount 2 multiple times for different coin choices. 
// This redundancy results in inefficiency, especially for larger inputs, and can lead to a time complexity that's exponentially large.

// To avoid these repeated calculations, we switch to a **bottom-up dynamic programming (DP)** approach:
// Bottom-up DP works by solving the problem iteratively, starting with the smallest subproblem and gradually building up to the larger ones.
// Instead of using recursion and recalculating subproblems from scratch, we solve all smaller subproblems first and store their results in a memoization array (or DP array),
// so that when we encounter a subproblem again, we can reuse the result directly (i.e., no recomputation).

// In the bottom-up approach:
// - We initialize the base case, `DP[0] = 0`, because to make an amount of 0, we need 0 coins.
// - We then iteratively calculate the minimum number of coins needed for all amounts from 1 to the target amount. For each amount, we check which coins can contribute to that amount,
//   and use the previously computed results (i.e., `DP[amount - coin]`) to update the current `DP[amount]` value.
// - By the time we get to `DP[amount]`, we have already solved all subproblems (from 0 to `amount - 1`) and can efficiently find the optimal number of coins needed.

// This approach is far more efficient because we avoid recalculating the same subproblems multiple times. Instead of starting fresh for each subproblem,
// we reuse previous results, resulting in a **time complexity of O(amount * number of coins)**, which is much more manageable than the exponential time complexity of the top-down approach.