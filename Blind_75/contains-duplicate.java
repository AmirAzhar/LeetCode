// 217. Contains Duplicate
// https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int val : nums)
            if (!set.add(val))
                return true;

        return false;
    }
}
