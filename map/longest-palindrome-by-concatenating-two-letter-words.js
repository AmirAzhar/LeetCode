// 2131. Longest Palindrome by Concatenating Two Letter Words
// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/

var longestPalindrome = function (words) {
  const map = {},
    rev = (el) => el.split("").reverse().join("");
  let max = 0;
  for (let word of words) {
    if (map[word]) {
      max += 4;
      map[word]--;
    } else {
      const revWord = rev(word);
      map[revWord] ? map[revWord]++ : (map[revWord] = 1);
    }
  }
  if (Object.keys(map).filter((el) => map[el] && el === rev(el)).length)
    max += 2;
  return max;
};
