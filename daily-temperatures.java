// https://leetcode.com/problems/daily-temperatures/description/

// Java
class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = temps.length - 1; i >= 0; i--) {
            while (!d.isEmpty() && temps[d.peekLast()] <= temps[i]) d.pollLast();
            res[i] = d.isEmpty() ? 0 : d.peekLast() - i;
            d.offerLast(i);
        }

        return res;
    }
}

// monotonic decreasing stack - temps on top must be > than the temo below
// The stack stores indices of temperatures, not the temperatures themselves.
// We iterate from the end of the array to the beginning, since we're looking for the "next" warmer day (which lies ahead in time).
// For each day:
    // We remove indices from the stack as long as their corresponding temperatures are less than or equal to the current day's temperature. These can't help us anymore.
    // If the stack is not empty, the top of the stack points to the next warmer day. The difference in indices tells us how many days to wait.
    // If the stack is empty, there's no warmer day in the future, so we record 0.
// After processing each day, we push its index onto the stack to possibly help future (earlier) days.
