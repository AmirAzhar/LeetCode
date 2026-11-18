// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function (s, p) {
  let res = [];

  if (p.length > s.length) return res;

  let target = new Array(26).fill(0),
    curr = new Array(26).fill(0);

  for (let i = 0; i < p.length; i++) target[p.charCodeAt(i) - "a".charCodeAt(0)]++;

  let l = 0,
    r = 0;

  while (r < s.length) {
    curr[s.charCodeAt(r) - "a".charCodeAt(0)]++;

    if (r - l + 1 === p.length) {
      if (target.every((ele, idx) => ele == curr[idx])) res.push(l);
      curr[s.charCodeAt(l) - "a".charCodeAt(0)]--;
      l++;
    }

    r++;
  }

  return res;
};

// Time: O(m + n) -> m is p.length and it is O(m) to build frequency count and n is s.length O(n) to loop through entire string
// Space: O(1) -> fixed size freq array

// we can use a sliding window of size p.length
// for every window, we can check if it is an anagram by looking at frequency
// we have 2 freq arrays - target and curr - and to check for anagram, simply see if all values are the same
// keep updating l and r
