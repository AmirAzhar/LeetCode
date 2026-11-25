# https://leetcode.com/problems/product-of-array-except-self/

class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:

        prod = 1
        res = []

        for i in range(len(nums)):
            res.append(prod)
            prod *= nums[i]

        prod = 1
        for i in range(len(nums) - 1, -1, -1):
            res[i] *= prod
            prod *= nums[i]
        
        return res
    
# We use prefix and suffix products to calculate the product of all elements except the current element, without division.
#
# In the first pass, we iterate from left to right.
# We maintain a running product of all elements before the current index and store it in the result array.
# We then multiply the current element into the running product.
#
# In the second pass, we iterate from right to left.
# We reset the running product and use it to track the product of all elements after the current index.
# We multiply this suffix product into the existing prefix product at each index to get the final result.
#
#
# Time: O(n) - two linear passes through the array.
# Space: O(1) - only a running product is maintained,
#        excluding the output array as specified by the problem.

# range(start, stop, step)
# len(nums) - 1 → 3: Start at the last valid index (Python uses zero-based indexing).
# -1 → stop: Stop before index -1. Since the stop value is exclusive, index 0 is still included.
# -1 → step: Decrement i by 1 each iteration, moving backward.