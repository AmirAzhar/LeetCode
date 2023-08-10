// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/

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
var reverseList = function (head) {
  let curr = head,
    next = null,
    prev = null;

  while (curr) {
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }

  return prev;
};

// Time: O(n)
// Space: O(1)
// while curr is not null (null means already at the end of the list)
// keep track of the next node
// make the current node point to the prev node
// make the prev node the curr node
// make the curr node the next node
