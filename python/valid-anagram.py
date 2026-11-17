# https://leetcode.com/problems/valid-anagram/description/

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        count = {}

        if len(s) != len(t):
            return False

        for char in s:
            count[char] = count.get(char, 0) + 1
        
        for char in t:
            if char not in count or count[char] == 0:
                return False
            count[char] -= 1
        
        return True

# for 2 words to be valid anagram, they should have the same
# good solution:
    # use 2 dicts to keep count of the characters for each of them
    # compare the keys and count for each of these dict
    # space: O(n) - 2 dict each holding n keys/val
    # time: O(n) - O(1) dict lookup for each char, and dict building
# more optimized
    # just use one dictionary
    # decrement values when iterating the other string
    # reject if value already 0 or key doesnt exist
    # reject at the end if any value still 0
    # similar time and space
    # space: O(n) - 1 dict each holding n keys/val
    # time: O(n) - O(1) dict lookup for each char, and dict building
# alternative
    # sort both of them and iterate each tgt
    # space: O(n) - recreating both string
    # time: O(n) - altho sort is O(nlogn) still need iterate the string