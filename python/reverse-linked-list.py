# https://leetcode.com/problems/reverse-linked-list/description/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode | None) -> ListNode | None:
        new_head = None

        while head:
            tmp = head.next
            head.next = new_head
            new_head = head
            head = tmp

        return new_head

# doing step, by step
# create a new node, which will eventually be the end of the new result
# need to retain the next node first, before cutting the link
# then update the next of teh current node, to point to the new list
# move forward both nodes for the old and new lists
# Space: O(1) - no new lists created
# Time: O(n) - go through the list onces and operations are O(1)