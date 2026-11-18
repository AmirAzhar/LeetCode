// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
  if (!head) return head;
  let dummy = new ListNode(0, head),
    slow = dummy,
    fast = dummy;

  while (n--) fast = fast.next;

  while (fast.next) {
    slow = slow.next;
    fast = fast.next;
  }

  slow.next = slow.next.next;

  return dummy.next;
};

// Time: O(n) -> single pass of the list
// Space: O(1)

// i can set up 2 pointers, such that the second pointer is n steps ahead
// i want the first pointer to stop at the node before the removed node so i can easily remove the removed node
// which means the loop stops when the fast node is null or .next is null, i can perform the removal
