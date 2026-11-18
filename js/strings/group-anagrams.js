// https://leetcode.com/problems/group-anagrams/description/

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
  let map = {};

  for (const s of strs) {
    let count = new Array(26).fill(0);

    for (const ch of s) count[ch.charCodeAt(0) - "a".charCodeAt(0)]++;

    let key = count.join(",");

    if (!map[key]) map[key] = [];

    map[key].push(s);
  }

  return Object.values(map);
};

// i can use a map, where the key is the sorted value of the stringm and the value is an array of all the strings
// however, this requires sorting each string
// m -> number of strings in the array (strs.length)
// n -> average length of each string (word.length)
// sorting will take O(nlogn), and do it for m words -> will take O(m * nlogn)

// Time: O(mn) -> for each string, process each letter into ascii
// Space: O(mn) -> the object/map needs to store all the strings

// alternatively we can do it without sorting
// we generate a key based on frequency of each letter
// anagrams should have the same frequency of letter
