// 150. Evaluate Reverse Polish Notation
// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

var evalRPN = (tokens) => {
  // Create a stack to store operands
  const stack = [];

  // Iterate through the tokens
  for (const token of tokens) {
    // If the token is an operator
    if (["+", "-", "*", "/"].includes(token)) {
      // Pop the last two operands from the stack
      const operand2 = stack.pop();
      const operand1 = stack.pop();

      // Perform the operation and push the result back onto the stack
      if (token === "+") stack.push(operand1 + operand2);
      else if (token === "-") stack.push(operand1 - operand2);
      else if (token === "*") stack.push(operand1 * operand2);
      else if (token === "/") stack.push(Math.trunc(operand1 / operand2));
    }
    // If the token is not an operator, it must be an operand
    // Convert it to a number and push it onto the stack
    else stack.push(Number(token));
  }

  // The final result should be the only remaining item on the stack
  return stack[0];
};
