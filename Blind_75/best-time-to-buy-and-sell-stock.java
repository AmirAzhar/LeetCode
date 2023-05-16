// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int currPrice : prices) {
            profit = Math.max(profit, currPrice - minPrice);
            minPrice = Math.min(currPrice, minPrice);
        }

        return profit;
    }
}

// init minPrice to MaxInt
// init profit to 0
// iterate through the prices
// update profit to max(profit, currPrice - minPrice)
// if currPrice < minPrice -> update the minPrice