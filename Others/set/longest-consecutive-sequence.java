// 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/description/

package set;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;

        // Create a set to remove any duplicates
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        for (int i : nums) {

            // Get the number before and after, and set max as the current length
            int max = 1, prevVal = i - 1, nextVal = i + 1;

            // As long as the set contains prevVal, it will be part of a consecutive
            // sequence
            // We increase the max
            // We remove from the set since the number has been used already
            // Decrement the prevVal and continue incraedsing max until there is no more
            // prevVal
            while (set.contains(prevVal)) {
                max++;
                set.remove(prevVal--);
            }

            // As long as the set contains nextVal, it will be part of a consecutive
            // sequence
            // We increase the max
            // We remove from the set since the number has been used already
            // Increment the nextVal and continue incraedsing max until there is no more
            // nextVal
            while (set.contains(nextVal)) {
                max++;
                set.remove(nextVal++);
            }

            // Update the res
            res = Math.max(res, max);
        }
        return res;
    }
}