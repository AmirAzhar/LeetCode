// 2667. Create Hello World Function
// https://leetcode.com/problems/create-hello-world-function/?utm_campaign=PostD1&utm_medium=Post&utm_source=Post&gio_link_id=QPDw0kJR

/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function (n) {
  let count = n;
  return function () {
    return count++;
  };
};

/**
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */
