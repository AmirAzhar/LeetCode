// 2623. Memoize
// https://leetcode.com/problems/memoize/description/?utm_campaign=PostD9&utm_medium=Post&utm_source=Post&gio_link_id=nRbADVd9

/**
 * @param {Function} fn
 */
function memoize(fn) {
  const memo = {};
  return function (...args) {
    const key = JSON.stringify(args);
    if (key in memo) return memo[key];
    memo[key] = fn(...args);
    return memo[key];
  };
}

/**
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1
 */
