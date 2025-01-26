// https://leetcode.com/problems/evaluate-reverse-polish-notation/

// Java
import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> ops = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

        for (String token : tokens) {
            if (ops.contains(token)) {
                int t1 = stack.pop();
                int t2 = stack.pop();
                int result;

                if (token.equals("+")) result = t2 + t1;
                else if (token.equals("-")) result = t2 - t1;
                else if (token.equals("*")) result = t2 * t1;
                else result = t2 / t1;
                stack.push(result);
            } 
            
            else stack.push(Integer.parseInt(token));
            
        }

        return stack.pop();
    }
}

// JS
var evalRPN = function(tokens) {
    const stack = []

    for (let token of tokens){

        if (["+", "-", "/", "*"].includes(token)) {
            let op2 = stack.pop()
            let op1 = stack.pop()

            if (token == "+") token = op1 + op2
            else if (token == "-") token = op1 - op2
            else if (token == "*") token = op1 * op2
            else token = Math.trunc(op1 / op2)
        } 

        stack.push(+token)

    }

    return stack[0]
};

// using a stack to keep track of numbers
// if token is an int, add the token to stack
// if it is an operator, pop the last 2 int in the stack and perform the operation -> then add the new result in the stack
// return the last standing element