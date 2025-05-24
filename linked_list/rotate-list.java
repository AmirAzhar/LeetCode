// https://leetcode.com/problems/rotate-list/description/

// Java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode slow = head, fast = head;
        int len = 0;

        // find length
        while (fast != null) {
            len++;
            fast = fast.next;
        }


        // get the modulo so that you dont go in loops
        int cut = k % len;

        // if cut is same length as the list, no need 
        if (cut == 0) return head;

        // move fast 'cut' ahead
        fast = head;
        while (cut > 0) {
            fast = fast.next;
            cut--;
        }


        // get slow to the cutting point
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // split the list
        ListNode toRotate = slow.next;
        slow.next = null;

        // get to the end of toRotate
        ListNode temp = toRotate;

        while (temp.next != null) temp = temp.next;

        // join the front
        temp.next = head;

        return toRotate;        
    }
}

// i dont actually have to rotate one by one like what the pic shows
// first i find the full length of the linked list
    // then i can do k % length so that i know how much to actually rotate -> cut
// i will use 2 pointers, where fast is cut ahead of the slow
    // slow.next will need to be null to cutoff
// get to the end of the scond half and just point that to the head
