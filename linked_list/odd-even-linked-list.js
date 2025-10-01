// https://leetcode.com/problems/odd-even-linked-list/description/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var oddEvenList = function (head) {
  if (!head || !head.next) return head;

  let odd = head,
    even = head.next,
    evenHead = even;

  while (even && even.next) {
    // point the nodes to the next upcoming node by skipping 1
    // update the odd and even nodes
    odd.next = even.next;
    odd = odd.next;

    even.next = odd.next;
    even = even.next;
  }

  odd.next = evenHead;

  return head;
};

// Time: O(n) -> single pass of the list
// Space: O(1)

// i can keep track of 2 pointers - odd and even
// this pointers will eventally point to the last element of its list
// since odd -> even, i also need to keep track of the head of the even so that i can easily connect both lists

// for odd number of nodes, it is fine but when there are odd numbers, even will reach null first before odd
// but once even is null, we can safely end the loop already because odd is properly stitched

// for even number of nodes, both odd and even will reach null at the same time
// so loop can easily stop when the next node is null
