// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/

var groupAnagrams = function (strs) {
  let map = {};

  strs.forEach((w) => {
    let count = Array(26).fill(0);
    w.split("").forEach((char) => {
      count[char.charCodeAt(0) - "a".charCodeAt(0)]++;
    });
    let key = count.toString();
    key in map ? map[key].push(w) : (map[key] = [w]);
  });
  return Object.values(map);
};
