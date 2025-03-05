//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

// Java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) return list;

        int[] target = new int[26];
        int[] curr = new int[26];

        for (char c : p.toCharArray()) target[c - 'a']++;

        int l = 0, r = 0;

        while (r < s.length()) {
        
            curr[s.charAt(r) - 'a']++;

            if (r - l + 1 == p.length()) {
                if (Arrays.equals(target, curr)) list.add(l);
                curr[s.charAt(l) - 'a']--;
                l++;
            }

            r++;
        }
        
        return list;
    }
}

// JS
var findAnagrams = function(s, p) {
    let list = [];
    
    if (s.length < p.length) return list;
    
    let target = new Array(26).fill(0);
    let curr = new Array(26).fill(0);
    
    // Create frequency map for characters in p
    for (let char of p) {
        target[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

    let l = 0, r = 0;

    while (r < s.length) {
        // Expand the window by including character at r
        curr[s.charCodeAt(r) - 'a'.charCodeAt(0)]++;

        // If the window size is equal to the size of p, check if it's an anagram
        if (r - l + 1 === p.length) {
            if (target.every((val, idx) => val === curr[idx])) {
                list.push(l);
            }

            // Shrink the window by excluding character at l
            curr[s.charCodeAt(l) - 'a'.charCodeAt(0)]--;
            l++;
        }

        r++;
    }
    
    return list;
};

// using a sliding window of fixed size p.length
// first if s.length < p.length return false

// i have left and right pointer, marking the start and end of a substr
// init array to keep track of freq for target
// i have an array keep track of freq for that substr
// keep checking if the arrays are the same