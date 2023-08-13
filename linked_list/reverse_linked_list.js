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
var reverseList_iterative = function (head) {
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

var reverseList_recursive = function (head) {
  if (!head) return null;

  newHead = head;
  if (head.next) {
    // if there still exists a subproblem
    newHead = reverseList_recursive(head.next);
    head.next.next = head;
  }
  head.next = null; // back at first head

  return newHead;
};

// for a recursive method, we first look at what the smaller sub problem is
// the smaller subproblem is to reverse the next node

var reverseList = function (head) {
  return reverseList_recursive(head);
  return reverseList_iterative(head);
};
