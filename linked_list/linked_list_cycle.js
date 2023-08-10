// 141. Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function (head) {
  if (!head) return false;

  let fast = head;

  while (fast && fast.next) {
    head = head.next;
    fast = fast.next.next;
    if (head === fast) return true;
  }
  return false;
};

// we can use the concept of the tortoise and a hare
// we use 2 pointers, where 1 pointer will be faster - by moving 2 nodes at a time instead of just one by the slow pointer
// if there is a cycle, the 2 pointers will eventually overlap
// if there is no cycle, the fast pointer would have reached the end of the list
