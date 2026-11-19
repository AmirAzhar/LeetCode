# https://leetcode.com/problems/merge-two-sorted-lists/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: ListNode | None, list2: ListNode | None) -> ListNode | None:
        res = ListNode(None)
        ptr = res

        while list1 and list2:
            if list1.val < list2.val:
                ptr.next = list1
                list1 = list1.next
            else:
                ptr.next = list2
                list2 = list2.next

            ptr = ptr.next
        
        ptr.next = list1 if list1 else list2

        return res.next
        
# i need to have 2 pointers, each starting at the start of each ndividual listnode
# we will compare the 2 nodes to see which is smaller, and take that one to be put in the new list
# we will progress to the next node for the one that was removed
# we will do this until either of the current pointer is null
# if the the other pointer still has nodes, just append to the sorted list
# Time: O(m + n) - each node is processed at most once.
# Space: O(1) - reuse existing nodes with only a dummy node and pointers.
