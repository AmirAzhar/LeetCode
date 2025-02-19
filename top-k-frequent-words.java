// https://leetcode.com/problems/top-k-frequent-words/

// JS
/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
var topKFrequent = function(words, k) {
    const maxHeap = new PriorityQueue((a, b) => {
        if (a.count > b.count) return -1;
        if (a.count < b.count) return 1;
        return a.word > b.word ? 1 : -1;
        }
    );

    const map = new Map();
    const res = [];

    for (const w of words) map.set(w, (map.get(w) || 0) + 1);
    for (const [word, count] of map) maxHeap.enqueue({word, count});
    while (k--) res.push(maxHeap.dequeue().word);
    

    return res;
};

