// 1207. Unique Number of Occurrences
// https://leetcode.com/problems/unique-number-of-occurrences/

var uniqueOccurrences = function (arr) {
  let map = {};
  for (const val of arr) map[val] = map[val] + 1 || 0;

  const notUnique = Object.values(map);
  const unique = new Set(notUnique);

  return unique.size == notUnique.length;
};
