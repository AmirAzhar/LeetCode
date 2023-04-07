// 21. Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/description/

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

package linked_list;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode();
        ListNode ptr = res;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }

        ptr.next = list1 == null ? list2 : list1;

        return res.next;

    }
}

// start by having a new list with an empty node
// have 2 pointers pointing to the start of each list
// while both pointers.next is not null
// check which pointer has the lower value and append to the newList
// shift pointer accordingly depending on which list was appended
// loop ends if one of the list is empty

// simply append the non-empty list to the new list