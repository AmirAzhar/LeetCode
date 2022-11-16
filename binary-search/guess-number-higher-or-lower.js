// 374. Guess Number Higher or Lower
// https://leetcode.com/problems/guess-number-higher-or-lower/description/

const guessNumber = function (n) {
  var l = 1;
  while (l <= n) {
    let mid = Math.ceil(l + (n - l) / 2),
      res = guess(mid);

    if (!res) return mid;
    else if (res < 0) n = mid - 1;
    else l = mid + 1;
  }
  return -1;
};
