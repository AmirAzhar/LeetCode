// https://leetcode.com/problems/rotate-list/description/

// Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            len += 1;
            tail = tail.next;
        }

        k = len - (k > len ? k % len : k);

        while (k != 0) {
            ListNode newTail = head;
            head = head.next;
            tail.next = newTail;
            tail = newTail;
            newTail.next = null;
            k--;
        }


        return head;
    }
}

// k = mod(k) if k > len
// tail to head by k == as head to tail by length - k, so i rotate head to tail by len - k
// i can easily keep track of the head and tail
// while k != 0
    // newTail = head
    // head = head.next
    // tail.next = newTail
    // tail = newTail
    // newTail.next = null
