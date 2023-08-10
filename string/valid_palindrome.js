// 125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/

/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function (s) {
  s = s.replace(/[^a-zA-Z0-9]/g, "").toLowerCase();
  let left = 0,
    right = s.length - 1;

  while (right > left) {
    if (s[left] != s[right]) return false;
    left++, right--;
  }
  return true;
};

// remove all non-alphanumeric characters and convert to lowercase
// have 2 pointers - 1 pointing at the start and 1 at the end of the string
// comapre the 2 chars at the pointers, and if any of 2 chars dont match -> return false
// return true after interating through whole string

// /[^a-zA-Z0-9]/g
// /: This indicates the start of the regular expression pattern.
// [^a-zA-Z0-9]: The ^ symbol inside square brackets [] denotes a negation or a "not" character class. It means that the regular expression will match any character that is NOT present within the square brackets. In this case, it matches any character that is not an uppercase letter (A to Z), not a lowercase letter (a to z), and not a digit (0 to 9).
// /: This indicates the end of the regular expression pattern.
// g: The g flag stands for "global." It tells the regular expression to perform a global search, which means it will find all occurrences   of the pattern within the input string. Without the g flag, the regular expression would stop after finding the first match.
