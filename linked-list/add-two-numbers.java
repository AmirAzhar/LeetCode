// https://leetcode.com/problems/add-two-numbers/description/

// Java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0); 
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            // add l1 if non empty
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            // add l2 if non empty
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10, null);
            curr = curr.next;
        }

        return dummy.next;
    }

}


// in the loop for adding, our while condition is if there is still any carry or non null nodes left
    // if checks for each list -> add to sum any list that is not empty
    // add carry to sum
    // to find out next carry -> sum / 10
    // to find out output val for that node -> sum % 10