// https://leetcode.com/problems/top-k-frequent-words/

/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
var topKFrequent = function (words, k) {
  const map = new Map();
  let res = [];
  let maxHeap = new PriorityQueue((a, b) => {
    if (a.count > b.count) return -1;
    if (a.count < b.count) return 1;
    return a.word > b.word ? 1 : -1;
  });

  for (const w of words) map.set(w, (map.get(w) || 0) + 1);

  for (let [word, count] of map) maxHeap.enqueue({ word, count });

  while (k--) res.push(maxHeap.dequeue().word);

  return res;
};

// Time: O(n + u log u) -> n is number of words and u is unique word -> for each unique word, we enqueue into the heap
// Space: O(u) -> for map and heap

// i will first use a map for me to count the frequency off the words
// i will insert into a heap which takes in {word, freq}
// the comparator of the heap will first check the freq then the lexigraphical of the word
// in the comparator, i need to check the frequency first
// since it is a maxHeap
// If a.count > b.count → return -1, meaning a should come before b (higher frequency = higher priority).
// If a.count < b.count → return 1, meaning b should come before a.
// then we compare lex (not really maxheap from this perspective)
// If a.word comes after b.word alphabetically, return 1, so b comes first.
// Otherwise, return -1, so a comes first.
