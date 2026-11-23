# https://leetcode.com/problems/middle-of-the-linked-list/description/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: ListNode | None) -> ListNode | None:
        # slow = fast = head
        # length = 0
        # ahead = 0

        # while head:
        #     length += 1
        #     head = head.next
        
        # if length % 2 == 0:
        #     ahead = (length // 2) - 1
        # else:
        #     ahead = length // 2

        # while ahead:
        #     fast = fast.next
        #     ahead -= 1
        
        # while fast.next:
        #     slow, fast = slow.next, fast.next

        # return slow

        slow = fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        return slow
            

# we first iter through the whole list, so we can find the length
# given the length, we then can halve it, to decide the difference in steo between the fast and lsow pointer
# fater the fast ptr is given that head start, they will increment one by one until the fast is null - that would mean the slow is in middle
# special handling between odd and even length
    # for even lengths, we want second middle node, so we decrtement the "ahead" by 1 so slow ends in teh right spot
# Time: O(n)- linear iteration of the list
# Space: O(1) - only variables

# We use the slow and fast pointer technique to find the middle node.
# Both pointers start at the head.
# Slow moves one node at a time, while fast moves two nodes at a time.
#
# We continue as long as fast and fast.next exist.
# Once fast reaches the end, slow will be at the middle node because it has travelled half the distance.
#
# For even-length lists, slow naturally ends at the second middlenode, which is what the problem requires.
#
# Time: O(n) - traverse the linked list once.
# Space: O(1) - only two pointers are maintained.