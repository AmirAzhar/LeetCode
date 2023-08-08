// 383. Ransom Note
// https://leetcode.com/problems/ransom-note/

/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function (ransomNote, magazine) {
  const freqMap = {};
  for (const char of magazine)
    char in freqMap ? freqMap[char]++ : (freqMap[char] = 1);
  for (const char of ransomNote) {
    if (!freqMap[char]) return false;
    freqMap[char]--;
  }
  return true;
};

// Time: O(n)
// Space: O(n)
// we need to first count the characters in the magazine using a map where k:v is letter:frequency
// then we iterate through the chars in the ransomnote
// for every char, we decrement the corresponding frequency in the map
// however, if the char is not in the map or the freq is 0, we return false
// if it succesfully iterated through ransomenote, it will be true
