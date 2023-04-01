// 1. Two Sum
// https://leetcode.com/problems/two-sum/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null)
                return new int[] { i, map.get(target - nums[i]) };
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}

// Better Solution
// Init a map -> key (number) : value (index)
// Iterate through the list
// we check if (target - current) is in map
// if in map, we have our 2 indices already
// if not in map, add the number:index into the map
// O(n)