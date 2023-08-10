// 409. Longest Palindrome
// https://leetcode.com/problems/longest-palindrome/

/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function (s) {
  let freqMap = {},
    res = 0;

  for (const char of s) {
    freqMap[char] = (freqMap[char] || 0) + 1;
    if (freqMap[char] % 2 == 0) res += 2;
  }

  return s.length > res ? res + 1 : res;
};

// Time: O(n)
// Space: O(n)
// use a map to keep count of the frequency of a char
// iterate through the chars of the string
// add 1 to the value of the string
// after adding, we check if the frequency is divisible by 2. If it is, we can add to palindrome (we need a pair of each char to create a palindrome)
// lastly, we check if the length of the string is longer that our res
// if it is, there can be some spare characters that can be placed in the middle of the palindrome (we dont care which char but can just increment)
