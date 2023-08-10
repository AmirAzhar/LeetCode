// 21. Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function (list1, list2) {
  let newList = new ListNode();
  const res = newList;

  while (list1 && list2) {
    if (list1.val < list2.val) {
      newList.next = list1;
      list1 = list1.next;
    } else {
      newList.next = list2;
      list2 = list2.next;
    }
    newList = newList.next;
  }

  newList.next = list1 ? list1 : list2;
  return res.next;
};

// create a new list newList
// iterate through each list  (until you reach the end of one of the list)
// compare the 2 values, whichever is lower,
// point the newList towards it
// update the pointer of that original list
// at the end, there could still be a list that is not empty, so append that to the end of the newList
// return the newList
