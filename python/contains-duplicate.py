# https://leetcode.com/problems/contains-duplicate/description/

class Solution:
    def containsDuplicate(self, nums: list[int]) -> bool:
        # return False if len(set(nums)) == len(nums) else True

        # For early termination
        my_set = set()
        for num in nums:
            if num in my_set:
                return True
            my_set.add(num)
            
        return False

# brute force: double for loop where we compare every value to see if any duplicates, but we end up doing so many repaeted comparisons
# optimized:
# we turn the list into a set and compare the length
# if the set length is shorter, means that there are duplicates
# space: O(n) - set same max size as nums
# time: O(n) - convert to set takes that time
