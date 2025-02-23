// https://leetcode.com/problems/first-unique-character-in-a-string/description/

// Java
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();

        for (char ch : chars) freq[ch - 'a']++;
        for (int i = 0; i < s.length(); i++) if (freq[chars[i] - 'a'] == 1) return i;

        return -1;
    }
}

// 2 iterations
// first iter to count the number of each chars
// second iter to check which is the first char with freq = 1