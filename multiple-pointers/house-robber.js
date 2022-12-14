// 198. House Robber
// https://leetcode.com/problems/house-robber/

var rob = function (nums) {
  let prev = 0,
    prev2 = 0;

  for (const num of nums) {
    let temp = Math.max(prev, prev2 + num);
    prev2 = prev;
    prev = temp;
  }
  return prev;
};
