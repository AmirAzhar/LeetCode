// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  const map = {
    "}": "{",
    "]": "[",
    ")": "(",
  };
  const stack = [];

  for (const char of s) {
    if (stack.length && map[char] === stack[stack.length - 1]) stack.pop();
    else stack.push(char);
  }

  return !stack.length;
};

// Time: O(n)
// Space: O(n)
// Need a map that opening bracket to its corresponding closing bracket (pair)
// Init a stack
// iterate through each char of the string
// If the stack is empty, add the char to the stack
// If the stack is not empty, compare with the char at the top of the stack
// if not a pair, add the char to the stack
// if pair, remove char from top of stack
