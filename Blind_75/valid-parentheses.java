// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/description/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>() {
            {
                put('{', '}');
                put('[', ']');
                put('(', ')');
            }
        };

        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            if (stack.size() > 0 && curr == map.get(stack.peek()))
                stack.pop();
            else
                stack.push(curr);
        }

        return stack.empty();

    }
}
