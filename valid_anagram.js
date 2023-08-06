// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
  if (s.length != t.length) return false;

  const freqMap = {};

  for (const char of s) char in freqMap ? freqMap[char]++ : (freqMap[char] = 1);
  for (const char of t) {
    if (!freqMap[char]) return false;
    freqMap[char]--;
  }

  return true;
};

// Time: O(n)
// Space: O(1)
// for two strings to be anagrams, they need to have the same number of each character and have the same length
// to keep track of this, we can use a map where the key is the char and the value is the freq
// compare lengths, if different -> return false
// first iterate through s, to find the frequency of each char in the string
// then iterate through t, for each char
// if char is not in the freqMap, return false
// if char is in the freqMap BUT freq is already zero, return false
// if char is in the freqMap AND freq is not zero, decrement the freq
