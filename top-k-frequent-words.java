// https://leetcode.com/problems/top-k-frequent-words/

// Java
class Solution {

    public class Pair {
        private String string;
        private int count;

        public Pair (String string, int count) {
            this.string = string;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.count > a.count) return 1;
            else if (b.count < a.count) return -1;
            else return a.string.compareTo(b.string);
        });

        ArrayList<String> res = new ArrayList<>();

        for (String word : words) freq.put(word, freq.getOrDefault(word, 0) + 1);

        for (Map.Entry<String, Integer> entry : freq.entrySet()) maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        
        while (k > 0) {
            res.add(maxHeap.poll().string);
            k--;
        }

        return res;
    }
}

// JS
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

// i need to use a map first to iterate and count the freq of each string
// then i can use a maxheap and add every kv pair in the map
// the maxheap needs to take in a custom comparator where it also checks the lexigrophical order of 2 strings if they both have the same freq