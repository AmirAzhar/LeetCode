// 70. Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/description/

class Solution {
    public int climbStairs(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;

        int prev1 = 1, prev2 = 2;

        for (int i = 3; i <= n; i++) {
            int newValue = prev1 + prev2;
            prev1 = prev2;
            prev2 = newValue;
        }

        return prev2;
    }
}

// Bottom Up approach
// Time: O(n) ; Space: O(1)
// Calculate the values for the smaller cases, then build the way up to n
