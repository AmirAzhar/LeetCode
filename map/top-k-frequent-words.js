// 692. Top K Frequent Words
// https://leetcode.com/problems/top-k-frequent-words/description/

var topKFrequent = function (words, k) {
  let map = {};
  for (const word of words) map[word] = map[word] + 1 || 0;
  return Object.keys(map)
    .map((key) => [key, Number(map[key])])
    .sort((a, b) => {
      // same values -> sort by key
      if (a[1] == b[1]) return (a[0] > b[0]) - (a[0] < b[0]);

      // else sort by
      return b[1] - a[1];
    })
    .map((pair) => pair[0])
    .slice(0, k);
};
