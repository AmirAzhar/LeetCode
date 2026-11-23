# https://leetcode.com/problems/majority-element/

class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        # count = {}
        # res = curr_max = 0

        # for num in nums:
        #     count[num] = count.get(num, 0) + 1
        
        # print(count)
        
        # for key in count:
        #     if count[key] > curr_max:
        #         res = key
        #         curr_max = count[key]
        
        # return res

        majority = nums[0]
        counter = 0

        for num in nums:
            if counter == 0:
                majority = num

            if num == majority:
                counter += 1
            else:
                counter -= 1
            
        return majority




# easist would be to have a dictinoary keeping count of the appearance of each number
# then i return the key with the largest value
# Time: O(n) - dict ops are O(1) and i need to do for each nums
# Space: O(n) - worst case is n if all numbers unique

# but how can i do it in O(1) space and linear time
# We use the Boyer-Moore Voting Algorithm to find the majority element.
# Since the majority element appears more than n/2 times, it cannot be completely cancelled out by the other elements.
#
# We maintain a candidate and a counter.
# As we iterate, if the counter is 0, we select the current number as our new candidate.
# If the number matches our candidate, we increment the counter.
# Otherwise, we decrement it, effectively cancelling out a pair.
#
# Since a majority element is guaranteed to exist, the final remaining candidate must be the majority element.
#
# Time: O(n) - traverse the array once.
# Space: O(1) - only maintain a candidate and counter.