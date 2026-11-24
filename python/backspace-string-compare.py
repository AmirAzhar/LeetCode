# https://leetcode.com/problems/backspace-string-compare/description/

class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        # stackS = []
        # stackT = []

        # for char in s:
        #     if char != "#":
        #         stackS.append(char)
        #     elif len(stackS):
        #         stackS.pop()

        # for char in t:
        #     if char != "#":
        #         stackT.append(char)
        #     elif len(stackT):
        #         stackT.pop()

        # return "".join(stackS) == "".join(stackT)

        i, j = len(s) - 1, len(t) - 1

        while i >= 0 or j >= 0:
            skipS = skipT = 0

            # Find next valid character in s
            while i >= 0:
                if s[i] == "#":
                    skipS += 1
                elif skipS > 0:
                    skipS -= 1
                else:
                    break
                i -= 1

            # Find next valid character in t
            while j >= 0:
                if t[j] == "#":
                    skipT += 1
                elif skipT > 0:
                    skipT -= 1
                else:
                    break
                j -= 1

            # Compare surviving characters
            if i >= 0 and j >= 0:
                if s[i] != t[j]:
                    return False
            elif i >= 0 or j >= 0:
                return False

            i -= 1
            j -= 1

        return True

# I can use a stack to keep track of the string for each of them
# # will essentially pop a char from the stack
# at the end, I join the stacks to compare the final strings
# Space: O(n+m) - a stack for each string
# Time: O(n) / O(m) - linear time iteration of each

# but it can done in O(1) space
# We use two pointers, starting at the end of each string.
# Instead of building the final strings with stacks, we traverse
# backwards and use skip counters to handle backspaces.
#
# When we encounter '#', we increment the skip counter.
# If we encounter a character while the counter is positive,
# we skip that character and decrement the counter.
# Otherwise, we've found the next valid character.
#
# We do this for both strings and compare their valid characters.
# If they differ, or only one string has characters remaining,
# we return False.
#
# If both strings are fully processed without mismatches,
# we return True.
#
# Time: O(n + m) - each character is processed at most once.
# Space: O(1) - only two pointers and skip counters.