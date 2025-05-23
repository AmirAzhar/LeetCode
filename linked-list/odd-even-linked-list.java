// https://leetcode.com/problems/odd-even-linked-list/description/

// Java
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return  head;

        ListNode odd = head, even = head.next, oddHead = head, evenHead = head.next;

        // use odd as a condition because if odd doesnt exit, even cant either
        // odd.next implies even, odd.next.next implies even.next
        while (odd.next != null && odd.next.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return oddHead;
    }
}

// head will be set as odd, head.next will be set as even

// odd.next = odd.next.next
// even.next = even.next.next
// odd = odd.next
// even = even.next