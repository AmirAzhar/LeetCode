// 520. Detect Capital
// https://leetcode.com/problems/detect-capital/description/

var detectCapitalUse = function (word) {
  // Rule 1: If the word is all uppercase to begin with, it is correct
  // Rule 2: If the word is not all uppercase, there are only 2 ways it can still be correct
  // first char upper and remaining is lower OR all lower
  // In both cases, we just have to check if the remaining chars are lower case, and ignore the first char
  return (
    word === word.toUpperCase() || word.slice(1) === word.slice(1).toLowerCase()
  );
};
