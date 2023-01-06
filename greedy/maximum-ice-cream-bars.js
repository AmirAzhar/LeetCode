// 1833. Maximum Ice Cream Bars
// https://leetcode.com/problems/maximum-ice-cream-bars/description/

var maxIceCream = function (costs, coins) {
  let res = 0;

  // Since order does not matter, we can sort in asc order, so we buy the cheaper oncse first
  costs.sort((a, b) => a - b);

  // Iterate through each bar
  for (const cost of costs) {
    // If the current bar is more expensive than the coins we have, return the res
    if (cost > coins) return res;

    // if we still have money, increase the res and rsubtract the cost of the bar from our coins
    res += 1;
    coins -= cost;
  }
  return res;
};
