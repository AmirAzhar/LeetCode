// 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/description/

var numSquares = function (n) {
  let mem = [0];
  let i, j;

  for (i = 1; i <= n; i++) {
    mem[i] = Infinity;
    for (j = 1; j * j <= i; j++) mem[i] = Math.min(mem[i], mem[i - j * j] + 1);
  }
  return mem[n];
};
