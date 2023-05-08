import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    // If there are no string, just return an empty ArrayList
    if (strs == null || strs.length == 0)
      return new ArrayList<>();

    // Create a new map where the key is the sorted string and the value is the list
    // of strings that are grouped
    Map<String, List<String>> map = new HashMap<>();

    // Iterate through the array of strings
    for (String str : strs) {

      // Sort the string by (1) converting to char array, (2) sorting the charArray,
      // (3) converting back to string
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sortedStr = String.valueOf(charArray);

      // Check if the sortedStr (key) is already in the map
      // if does not exist, create a new ArrayList first as the value
      if (!map.containsKey(sortedStr))
        map.put(sortedStr, new ArrayList<>());
      // Then add the str in the arrayList
      map.get(sortedStr).add(str);
    }

    // return the values of the map as an arraylist
    return new ArrayList<>(map.values());
  }
}
