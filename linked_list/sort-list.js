// https://leetcode.com/problems/sort-list/

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
var sortList = function (head) {
  let vals = [],
    dummy = head,
    res = head;

  while (head) {
    vals.push(head.val);
    head = head.next;
  }

  vals.sort((a, b) => a - b);

  for (let val of vals) {
    dummy.val = val;
    dummy = dummy.next;
  }

  return res;
};

// Time: O(nlogn) -> default sort is usually nlogn
// Space: O(n) -> create an array

// instead of sorting the list itself, i can sort the values in a normal array, and then rewrute the list with the values
// ill just iterate through the list and append the values to the list
// sort the list
// iterate the list again but now overwrite the values
