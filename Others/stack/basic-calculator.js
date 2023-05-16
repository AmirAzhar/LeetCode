// 224. Basic Calculator
// https://leetcode.com/problems/basic-calculator/

/**
 * @param {string} s
 * @return {number}
 */
var calculate = function (s) {
  let sum = 0,
    sign = 1;
  let stack = [];

  for (let i = 0; i < s.length; i++) {
    if (!isNaN(parseInt(s[i]))) {
      let num = 0;
      while (!isNaN(parseInt(s[i]))) {
        num = num * 10 + parseInt(s[i]);
        i += 1;
      }
      sum += num * sign;
      i -= 1; // need this because, the +1 in while loop will cause the index to extend by 1 during the last index
    } else if (s[i] === "+") sign = 1;
    else if (s[i] === "-") sign = -1;
    else if (s[i] === "(") {
      stack.push(sum);
      stack.push(sign);
      sum = 0;
      sign = 1;
    } else if (s[i] === ")") {
      sum *= stack.pop(); //sign
      sum += stack.pop(); //sum
    }
  }
  return sum;
};
