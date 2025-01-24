// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// Java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        if (len <= 1) return len;

        int start = 0;
        int end = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<>();

        while (end < len){
            char endChar = arr[end];
            if (end == 0) set.add(endChar);
            else {
                if (set.contains(endChar)){
                    while (set.contains(endChar)){
                        set.remove(arr[start]);
                        start++;
                    }
                }
                set.add(endChar);
            }
            max = Math.max(max, set.size());
            end++;
        }

        return max;
    }
}
// JS
var lengthOfLongestSubstring = function(s) {
    let l = 0, r = 0, max = 0, set = new Set()

    while (r < s.length) {
        if (set.has(s[r])) {
            while (set.has(s[r])) {
                set.delete(s[l])
                l++
            }
        }
        set.add(s[r])
        max = Math.max(max, r - l + 1)
        r++
    }

    return max
};

// We can use a sliding window approach to solve the problem.
// Both pointers (l and r) start at the beginning of the string (index 0).
// The 'set' keeps track of all unique characters in the current window (substring).
// Move the right pointer (r) by 1 and add the new character into the set.
//     - If the character is not already in the set, update the max length of the current substring.
//     - If the character is already in the set (duplicate character):
//         - Move the left pointer (l) to the right, one character at a time, 
//           while also removing characters from the set, until the set no longer contains the duplicate.
// After each iteration, update the max length of the substring.