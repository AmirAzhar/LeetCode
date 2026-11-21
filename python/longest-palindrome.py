# https://leetcode.com/problems/longest-palindrome/description/

class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = {}
        length = 0

        for char in s:
            count[char] = count.get(char, 0) + 1

        for freq in count.values():
            length += (freq // 2) * 2
        

        return length + 1 if length < len(s) else length
            

        

# We use a greedy approach to construct the longest possible palindrome.
# First, count the frequency of each character using a dictionary.
# A palindrome needs matching pairs on both sides, with at most one unmatched character allowed in the middle.
# For each character, we take as many pairs as possible and add their contribution to the total length.
# After using all available pairs, if there are any leftover characters, we can place exactly one in the middle.
#
# Time: O(n) - count characters and process their frequencies.
# Space: O(k) - dictionary stores k unique characters.
#        O(1) for this problem's fixed character set.
