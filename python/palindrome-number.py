# https://leetcode.com/problems/palindrome-number/

class Solution:
    def isPalindrome(self, x: int) -> bool:
        # if x < 0:
        #     return False
        
        # digits = []

        # while x:
        #     d = x % 10
        #     x = x // 10
        #     digits.append(d)
        
        # l, r = 0, len(digits) - 1

        # while l < r:
        #     if digits[l] != digits[r]:
        #         return False
        #     l += 1
        #     r -= 1
        
        # return True

        if x < 0 or (x % 10 == 0 and x != 0):
            return False

        reversed_half = 0

        while x > reversed_half:
            reversed_half = reversed_half * 10 + x % 10
            x //= 10

        return x == reversed_half or x == reversed_half // 10
        
# if a number is negative, it immediately cannot be a plindrome
# without converting into a stribng, we can perform match operations to get all the digits into an array
# then we can use a 2 pointer to compare the values
# Space: O(n) - newa array to store all digits
# Time: O(n) - linera iteration of the digits

# But how to do it without extra array?
# We can optimize the space by reversing only half of the number.
# Negative numbers and non-zero numbers ending in 0 cannot be palindromes.
#
# We maintain a reversed_half variable, initially 0.
# In each iteration, we extract the last digit of x and append it to reversed_half, while removing that digit from x.
#
# We stop once reversed_half is greater than or equal to x, meaning we've processed at least half the digits.
#
# For even-length numbers, both halves should be equal.
# For odd-length numbers, we ignore the middle digit by dividing reversed_half by 10 before comparing.
#
# Time: O(d) - process approximately half the digits.
# Space: O(1) - only use a few integer variables.

# x = 1221
# x = 12
# reversed_half = 12

# x = 12321
# x = 12
# reversed_half = 123