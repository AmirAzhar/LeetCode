# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        res = 0
        lowest = prices[0]

        for p in prices:
            lowest = min(lowest, p)
            res = max(res, p - lowest)

        return res

# Greedy / running minimum
# Track the lowest buying price encountered so far.
# At each price, calculate the potential profit if we sell today.
# Update the maximum profit whenever we find a better opportunity.
# Space: O(1)
# Time: O(n) - iterathe through list once and the min max functions are O(1)