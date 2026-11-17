# https://leetcode.com/problems/valid-palindrome/description/

class Solution:
    def isPalindrome(self, s: str) -> bool:
        l, r = 0, len(s) - 1

        while l < r:
            while l < r and not s[l].isalnum():
                l += 1
            while l < r and not s[r].isalnum():
                r -= 1
            
            if s[l].lower() != s[r].lower():
                return False
            
            l += 1
            r -= 1

        return True
            
        

# i need to check if both odd/even letter words are palindrome
# i can easily use a 2 pointer
    # each pointer starts on opposite end
    # as long as the letters are the same, i increment or decrement the pointers
    # if they are opposite, i can immediately return false
    # i do the loop until the indices cross/overlap -> this handles both odd and even letters
    # space: O(n) -> a copy of the string of same or shorter length
    # time: O(n) -> O(n/2) simplifies directly to O(n) 
# alternate
    # instead of wasting space to reate a clean verion of the string, i can handle it while iterating
    # essentially skipping the non alnum chars, and update the idx accordingly
    # space: O(1) -> no new clean copy
    # time: O(n) -> but slower since per char isalnum check and lower()