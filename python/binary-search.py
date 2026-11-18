# https://leetcode.com/problems/binary-search/

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        l, r = 0, len(nums) - 1

        while l <= r:
            m = (r + l) // 2
            if nums[m] == target:
                return m
            elif nums[m] > target:
                r = m - 1
            else:
                l = m + 1
        
        return -1
        

# classic binary search givn the nums is sorted
# start with 2 pointers at opposite end and take the middle of those 2
# if middle is more than target, search left by moving right ptr to mid - 1
# if middle is less than target, search right by moving left ptr to mid + 1
# when calc mid, no need worry about overflow in python as it reallocates more memory
# space: O(1) - only few variables
# time: O(logn) - search size is halved every iter