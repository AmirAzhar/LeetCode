// https://leetcode.com/problems/longest-substring-without-repeating-characters/

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  let lastSeen = new Map(),
    l = 0,
    res = 0;

  for (let r = 0; r < s.length; r++) {
    let char = s[r];

    // If char is already in map and index >= left, move left
    if (lastSeen.has(char) && lastSeen.get(char) >= l) l = lastSeen.get(char) + 1;

    // Update latest index of char
    lastSeen.set(char, r);

    // Update max length
    res = Math.max(res, r - l + 1);
  }

  return res;
};

// Time: O(n)

// i will init a max variable with 0
// and i will use a sliding window approach to keep track of my current string
// i will also use a set to keep track of all the characters in the string
// i will increment right
// as long as s[r] is already in the set, i will kep incrementing l + removing l from the set

// but instead, of that, there is a possibility where the inner while loop will take v long
// would be good if there is a way to skip forward to where the last seen was
// so we can use a map to keep track of the index the char was last seen
// then wwhen we see duplicate, we can easily skip ahead to where the char was las tseen
