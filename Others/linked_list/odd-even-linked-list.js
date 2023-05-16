// 328. Odd Even Linked List
// https://leetcode.com/problems/odd-even-linked-list/description/

var oddEvenList = function (head) {
  if (!head) return head;

  var odd = head;
  var even = head.next;

  while (odd.next && odd.next.next) {
    var tmp = odd.next;
    odd.next = odd.next.next;
    odd = odd.next;
    tmp.next = odd.next;
  }
  odd.next = even;
  return head;
};
