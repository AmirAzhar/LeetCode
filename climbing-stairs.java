// https://leetcode.com/problems/climbing-stairs/

// class Solution {
//     public int climbStairs(int n) {
//         if (n == 1) return 1;
//         if (n == 2) return 2;

//         return climbStairs(n - 1) + climbStairs(n - 2);
//     }
// }

// fxn(n) = fxn(n - 1) + fxn(n - 2)
// base case: n == 1 -> return 1
// base case: n == 2 -> return 2
// this solution will cause TLE is there is alot of repeated computation

class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev2 = 1;
        int prev = 2;

        for (int i = 3; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}

// we can try to do a bottom up
// we have prev2 = 1 and prev1 = 2
// curr will essentially be prev2 + prev1
// we simply update each of the maccoridnglt
    // prev2 = prev1
    // prev1 = prev2 + prev1