// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

// Java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        if (head.next == null) return null;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;


        return head;
    }
}

// if the head or head.next is null, we just return an empty ListNode
// we then can setup 2 poiinters - fast and slow
    // fast will be n nodes ahead of slow
    // we can use a while loop to do this
// then we do another while loop to incremenet both pointers at the same time
    // we stop when fast.next = null which means that we have reached the end
// we then update
    // temp = slow.next -> the one to be removed
    // slow.next = slow.next.next -> point the node to the following on
    // temp.next = null -> cutoff the removed node
// i have an issue if n is the length of the linkedlist, basically emoving first element
    // we can catch this by checking if fast is null