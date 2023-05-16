// 2629. Function Composition
// https://leetcode.com/problems/function-composition/description/?utm_campaign=PostD7&utm_medium=Post&utm_source=Post&gio_link_id=4PY7wZM9

/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function (functions) {
  return function (x) {
    for (let i = functions.length - 1; i >= 0; i--) x = functions[i](x);
    return x;
  };
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
