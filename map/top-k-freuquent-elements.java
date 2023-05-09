// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/description/

package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create map where the key is num and value is frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // Get the keys of the map and sort based on its values
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Convert ArrayList to int[]
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = list.get(i);

        return res;
    }
}