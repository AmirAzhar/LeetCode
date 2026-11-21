# https://leetcode.com/problems/linked-list-cycle/description/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow = fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow is fast:
                return True
        
        return False


# with the tortoise and hare, we make use of 2 pointers, where one of them is faster than the other
# In a finite cycle, a pointer moving one step faster gains one position per iteration. Eventually, that gap becomes zero, meaning both pointers reference the same node.
# the slow ptr moves by one hop while the fast ptr moves by 2 hops
# if the ptrs end up being the same as it progresses, theres a loop
# if the fast one reaches null first, no loop
# Time: O(n)
# - No cycle: fast reaches the end in O(n) steps.
# - Cycle: pointers meet within O(n) steps.
# Space: O(1) - only two pointers.
