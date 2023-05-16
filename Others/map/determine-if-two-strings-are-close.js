// 1657. Determine if Two Strings Are Close
// https://leetcode.com/problems/determine-if-two-strings-are-close/description/

var closeStrings = function (word1, word2) {
  const A = "a".charCodeAt(0);
  let map1 = Array(26).fill(0),
    map2 = Array(26).fill(0);

  for (let i = 0; i < word1.length; i++) map1[word1.charCodeAt(i) - A]++;
  for (let i = 0; i < word2.length; i++) map2[word2.charCodeAt(i) - A]++;

  for (let i = 0; i < 26; i++)
    if ((map1[i] === 0 && map2[i] !== 0) || (map2[i] === 0 && map1[i] !== 0))
      return false;

  map1.sort((a, b) => b - a);
  map2.sort((a, b) => b - a);

  for (let i = 0; i < 26; i++) {
    if (map1[i] !== map2[i]) return false;
    if (map1[i] === 0) break;
  }

  return true;
};
