// 150. Evaluate Reverse Polish Notation
// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function (tokens) {
  const stack = [];

  for (let token of tokens) {
    if (["+", "-", "/", "*"].includes(token)) {
      let op2 = stack.pop();
      let op1 = stack.pop();

      if (token == "+") token = op1 + op2;
      else if (token == "-") token = op1 - op2;
      else if (token == "*") token = op1 * op2;
      else token = Math.trunc(op1 / op2);
    }

    stack.push(+token);
  }

  return stack[0];
};

// Time complexity: O(n) -> We iterate over the 'tokens' array once, where n is the number of tokens.
// Space complexity: O(n) -> The stack holds at most n/2 numbers in the worst case (when there are no operators).

// using a stack to keep track of numbers
// if token is an int, add the token to stack
// if it is an operator, pop the last 2 int in the stack and perform the operation -> then add the new result in the stack
// return the last standing element
