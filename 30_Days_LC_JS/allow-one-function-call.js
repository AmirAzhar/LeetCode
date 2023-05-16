// 2666. Allow One Function Call
// https://leetcode.com/problems/allow-one-function-call/description/?utm_campaign=PostD8&utm_medium=Post&utm_source=Post&gio_link_id=a9By01Oo

/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function (fn) {
  let call = false;
  return function (...args) {
    if (call) return undefined;
    call = true;
    return fn(...args);
  };
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
