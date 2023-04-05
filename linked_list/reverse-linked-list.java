// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/

package linked_list;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
