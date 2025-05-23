// https://leetcode.com/problems/sort-list/

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
            
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
            
        return merge(l1, l2);
    }


    public ListNode merge(ListNode list1, ListNode list2){
        ListNode head = new ListNode();
        ListNode res = head;

        while (list1 != null && list2 != null){

            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            }

            else {
                head.next = list2;
                list2 = list2.next;
            }

            head = head.next;
        }

        head.next = (list1 != null) ? list1 : list2;

        return res.next;
    }
}

// the issue with sorting here is that it is not easy to access each of the nodes, and swap
// also we need to try to do in O(1) space, so it is trivial to store the values in pq n first traveral then re-edit the list in scond traversal
// use mergesort which is nlogn