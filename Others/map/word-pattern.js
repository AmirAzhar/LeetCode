// 290. Word Pattern
// https://leetcode.com/problems/word-pattern/description/

var wordPattern = function (pattern, s) {
  const words = s.split(" ");

  // key is the char from `pattern` and value is the word from `s`
  const map = {};

  // Base Case 1: If the number of chars in the pattern is not the same as the number of words in the string -> false
  if (words.length !== pattern.length) return false;

  // Base Case 2: There are different number of unique chars and unique words -> false
  if (new Set(words).size !== new Set(pattern).size) return false;

  // Iterate through each char in pattern
  for (let i = 0; i < pattern.length; i++) {
    let char = pattern[i],
      word = words[i];

    // If the char already exists in the map but the word associated to it is different -> false
    if (map[char] && map[char] !== word) return false;

    // The char does not exist in the map yet, so add to the map
    map[char] = word;
  }
  return true;
};
