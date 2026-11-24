# https://leetcode.com/problems/move-zeroes/description/

class Solution:
    def moveZeroes(self, nums: list[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        insert_pos = 0 # Next position where a non-zero value belongs.

        for i in range(len(nums)): # Current position being examined.
            if nums[i] != 0:
                nums[insert_pos], nums[i] = nums[i], nums[insert_pos]
                insert_pos += 1

# We use two pointers to move all zeroes to the end in-place.
# One pointer iterates through the entire array.
# The other tracks the next position where a non-zero should be placed.
# Whenever we encounter a non-zero element, we swap it into that position and increment the non-zero position pointer.
# This keeps all non-zero elements in their original relative order, while pushing zeroes towards the end.
#
# Time: O(n) - traverse the array once.
# Space: O(1) - only two pointers, modifying the array in-place.
            

        