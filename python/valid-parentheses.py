# https://leetcode.com/problems/valid-parentheses/

class Solution:
    def isValid(self, s: str) -> bool:
        brackets = {
            ")" : "(",
            "}" : "{",
            "]" : "["
        }
        stack = []

        for char in s:
            if char in brackets:
                if not stack or stack[-1] != brackets[char]:
                    return False
                stack.pop()
            else:
                stack.append(char)
        
        return not stack

        

# it is easy case if the direct pair comes right after it, but as seen in case 4 and 5, it may come in a later time
# we can use a stack to add the elements one by one
# if it is a pair, we will remove it from the stack
# if the stack is empty at the end of the iteration, true
# improvement:
    # we can fail fast if we see a closing bracket with an empty stack
    # we can fail fast if we see the wrong closing bracket with the wrong pair in the stack
# Time: O(n) - iterate the string once and stack opeartion is O(1) at most n times (length of s)
# Space: O(n) - max size of stack is length of s