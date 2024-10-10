// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  let l = 0,
    r = 0,
    max = 0,
    set = new Set();

  while (r < s.length) {
    if (set.has(s[r])) {
      while (set.has(s[r])) {
        set.delete(s[l]);
        l++;
      }
    }
    set.add(s[r]);
    max = Math.max(max, r - l + 1);
    r++;
  }

  return max;
};

// Time complexity: O(n) -> We iterate over the string once, and each character is added and removed from the set at most once.
// Space complexity: O(n) -> The set holds at most n unique characters, where n is the length of the string.

// We can use a sliding window approach to solve the problem.
// Both pointers (l and r) start at the beginning of the string (index 0).
// The 'set' keeps track of all unique characters in the current window (substring).
// Move the right pointer (r) by 1 and add the new character into the set.
//     - If the character is not already in the set, update the max length of the current substring.
//     - If the character is already in the set (duplicate character):
//         - Move the left pointer (l) to the right, one character at a time,
//           while also removing characters from the set, until the set no longer contains the duplicate.
// After each iteration, update the max length of the substring.
