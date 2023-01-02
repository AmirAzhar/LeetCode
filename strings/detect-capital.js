// 520. Detect Capital
// https://leetcode.com/problems/detect-capital/description/

var detectCapitalUse = function (word) {
  return (
    word === word.toUpperCase() || word.slice(1) === word.slice(1).toLowerCase()
  );
};
