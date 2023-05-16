// 2632. Curry
// https://leetcode.com/problems/curry/description/?utm_campaign=PostD10&utm_medium=Post&utm_source=Post&gio_link_id=QRekxgjo

/**
 * @param {Function} fn
 * @return {Function}
 */
var curry = function (fn) {
  return function curried(...args) {
    if (args.length == fn.length) return fn(...args);
    return function (...args2) {
      return curried(...args, ...args2);
    };
  };
};

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */
