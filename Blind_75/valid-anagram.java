// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/description/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];

        for (char c : s.toCharArray())
            map[c - 'a']++;
        for (char c : t.toCharArray())
            map[c - 'a']--;

        for (int val : map)
            if (val != 0)
                return false;
        return true;
    }
}
