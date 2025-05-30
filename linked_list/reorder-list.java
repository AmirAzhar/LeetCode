// https://leetcode.com/problems/reorder-list/description/

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return; 

        // 1. find mid
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. split the list
        ListNode h1 = head;
        ListNode h2 = slow.next;
        slow.next = null;


        // 3. reverse h2
        ListNode prev = null;
        ListNode curr = h2;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        h2 = prev;

        // 4. weave
        ListNode p1 = head;
        ListNode p2 = h2;

        while (p2 != null) {
            // save next pointers
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;

            // weave p2 in between p1 and next1
            p1.next = p2;
            p2.next = next1;

            // advance down each list
            p1 = next1;
            p2 = next2;
        }

        return;
    }
}

// i need to find the mid so that i can split the array into 2
    // 123 45
// i can then reverse the second array
    // 123 54
// now i can easily weave between both lists
    // use a while condition that checks if second list is null
    // if null means no more to splice
    // second half will alywas be smaller than the first half due to the splitting