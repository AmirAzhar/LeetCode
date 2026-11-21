# https://leetcode.com/problems/first-bad-version/

# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        l, r = 1, n

        while (l < r):
            m = (l + r) // 2

            if isBadVersion(m):
                r = m
            else:
                l = m + 1

        return l


# We use binary search to find the first bad version.
# Maintain two pointers, l and r, representing the range where
# the first bad version must exist.

# At each iteration, we check the midpoint.
# If the midpoint is bad, we search the left half, including the midpoint itself, since it could be the first bad version (r = m).
# If the midpoint is good, we search the right half, excluding the midpoint since it cannot be the answer (l = m + 1).

# We use while l < r because we want to narrow the search range
# until only one possible candidate remains.
# Once l == r, both pointers point to the first bad version,
# so we can return l (or r).

# Time: O(log n) - search range is halved each iteration.
# Space: O(1) - only a few pointers are maintained.
