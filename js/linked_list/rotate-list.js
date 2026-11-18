// https://leetcode.com/problems/rotate-list/description/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

/**
 * Rotates the list to the right by k places.
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
function rotateRight(head, k) {
  if (!head || !head.next || k === 0) return head;

  // 1) Find length and the tail in one pass
  let len = 1; // start at 1 since we're at head
  let tail = head;
  while (tail.next) {
    tail = tail.next;
    len++;
  }

  // 2) Normalize k so we don't over-rotate
  k = k % len;
  if (k === 0) return head;

  // 3) Make the list circular
  tail.next = head;

  // 4) Find the new tail: (len - k - 1) steps from current head
  let stepsToNewTail = len - k - 1;
  let newTail = head;
  while (stepsToNewTail--) newTail = newTail.next;

  // 5) The node after newTail is the new head; break the circle
  const newHead = newTail.next;
  newTail.next = null;

  return newHead;
}

// Time: O(n) -> traverse to find lentgth and to cut O(n) + O(n)
// Space:: O(1)

// i dont actually need to rotate
// first i can try to get the length of the list and the amount i need rotate is length % k if k > length -> this is normalizing k
// then to find the new tail, we take the len - k - 1, and go to the node/link to break
// we then join and rmb to break the link
