// 899. Orderly Queue
// https://leetcode.com/problems/orderly-queue/description/

const orderlyQueue = function (s, k) {
  // For any string you can move any char to anywhere if you can swap adjacent characters
  // So by the end of the swapping, the lexicographically smallest will essentially be the sorted string
  if (k > 1) return s.split("").sort().join("");

  let res = s;

  // We only need to care about the k = 1 case
  // We iterate theough the string, moving one char at a time and seeing if it is smaller
  for (let i = 0; i < s.length; i++) {
    s = s.slice(1) + s[0];
    res = res.localeCompare(s) < 0 ? res : s;
  }

  return res;
};
