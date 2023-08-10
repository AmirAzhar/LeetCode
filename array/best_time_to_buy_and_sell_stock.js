// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let lowestPrice = Number.MAX_SAFE_INTEGER;
  let maxProfit = 0;

  for (const currentPrice of prices) {
    lowestPrice = Math.min(currentPrice, lowestPrice);
    maxProfit = Math.max(currentPrice - lowestPrice, maxProfit);
  }

  return maxProfit;
};

// init lowestPrice as largest integer
// init maxProfit as 0
// iterate through the prices
// update the lowestPrice if the price is lower than the min
// update the maxProfit if the currentPrice - lowestPrice is greater than maxProfit
