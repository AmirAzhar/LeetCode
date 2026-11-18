// https://leetcode.com/problems/decode-string/submissions/1609252983/

// Java
class Solution {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder currStr = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {

            // find the repeat
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } 

            else if (ch == '[') {
                // Push the current string and repeat count to the stack
                stack.push(currStr.toString());
                stack.push(String.valueOf(k));

                // Reset for new part
                currStr.setLength(0);
                k = 0;
            } 

            // end of decoded string
            else if (ch == ']') {
                // Pop repeat count and previous string
                int repeat = Integer.parseInt(stack.pop());
                StringBuilder prevstr = new StringBuilder(stack.pop());

                // Repeat the current string `k` times
                for (int i = 0; i < repeat; i++) prevstr.append(currStr);
                
                // Update currStr with the repeated string
                currStr = prevstr;
            } 
            // add to curr string
            else currStr.append(ch);
        }

        return currStr.toString();
    }
}

// Approach:
// 1. We can use a stack to manage the structure of the input string. 
// 2. Whenever we encounter a digit, we will build the repeat count k. This could be a multi-digit number, so we need to handle that.
// 3. When we encounter the opening bracket '[', it indicates the start of an encoded string. 
//    We'll push the current repeat count (k) and the current string we've built so far onto the stack.
//    We will then reset the current string (because we are about to build a new encoded string).
// 4. When we encounter the closing bracket ']', it means we've reached the end of an encoded part.
//    We pop the previous string and repeat count from the stack, repeat the current string 'k' times,
//    and then concatenate the result with the previous string.
// 5. For characters inside the brackets, we'll just keep appending them to our current string until we hit a closing bracket.
// 6. Finally, when we've processed all the characters, we return the decoded string.