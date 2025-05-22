// https://leetcode.com/problems/swap-nodes-in-pairs/description/

// Java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = new ListNode(0, head), newHead = head.next;

        while (prev.next != null && prev.next.next != null) {
            ListNode swap1 = prev.next, swap2 = prev.next.next;
            swap1.next = swap2.next;
            swap2.next = swap1;
            prev.next = swap2;
            prev = swap1;
        }

        return newHead;
    }
}

// i want to swap every adjacent nodes
// if the head == null || head.next == null -> return head

// to perform a swap between swap1 and swap2
    // swap1.next = swap2.next
    // swap2.next = swap1
    // prev.next = swap1
    // prev.next = swap2;
    // prev = swap1;

// so i will do a while loop with condition (prev.next && prev.next.next)
// but i am losing the head
    // so at the start i just set the newHead/res to be the head.next
    // after the swap, that HAS to be the head