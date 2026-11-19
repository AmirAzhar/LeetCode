# https://leetcode.com/problems/ransom-note/description/

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        count = {}

        for char in magazine:
            count[char] =  count.get(char, 0) + 1
        
        for char in ransomNote:
            if count.get(char, 0) == 0:
                return False
            count[char] -= 1
        
        return True

# we need to ensure that all chars in ransomnote, can be found in magazine
# we first need to keep a count of all chars in magazine, using a dictionary and iterating througgh
# then we iterate through ransomnote and decrement teh count for each char
# hwoever if the char count is already 0 before decrement, return False
# Space: O(k) - number of unique characters
# Time: O(n) - iterate each string and each dict op is O(1)
