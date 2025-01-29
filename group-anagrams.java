// https://leetcode.com/problems/group-anagrams/

// Java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs){
            char[] count = new char[26]; 
            for (char ch : s.toCharArray()) count[ch - 'a']++;
            String key = new String(count);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

// JS
var groupAnagrams = function(strs) {
    let map = {}
    let sortedStr

    for (const str of strs){
        sortedStr = str.split('').sort().join('')
        if(!map[sortedStr]) map[sortedStr] = []
        map[sortedStr].push(str)
    }

    return Object.values(map)
};


// use a map to keep track of the grouping
// key can be the sorted string OR the count of chars
// iterate through string and group them accordingly
// return map values