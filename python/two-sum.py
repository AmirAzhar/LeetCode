# https://leetcode.com/problems/two-sum/description/

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        positions = {}
        for id, num in enumerate(nums):
            if target - num in positions:
                return [positions[target - num], id]
            positions[num] = id
    

# i need to find a pair of numbers that add to the target
# brute force: double for loop, to iterate through all permutations of the number, until pair is found -> O(n^2) time
# optimize: 
    # use a dict to maintain what numbers we have seen
    # iterate through the list such, first check of we have the sum pair
    # if have sum pair, just return the pair
    # if no sum pair, add to dict and move on to next number
        