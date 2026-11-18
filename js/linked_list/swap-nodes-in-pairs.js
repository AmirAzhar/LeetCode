// https://leetcode.com/problems/swap-nodes-in-pairs/description/

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
var swapPairs = function(head) {
    if (!head || !head.next) return head;

    let dummy = new ListNode(0, head);
    let prev = dummy;

    while (prev.next && prev.next.next) {
        let n1 = prev.next, n2 = prev.next.next;

        n1.next = n2.next;
        n2.next = n1;
        prev.next = n2;

        prev = prev.next.next;
    }

    return dummy.next;

};

// Time: O(n) -> single passtrhough of the list
// Space: O(1)

// we need a way to easily manipulate the 2 nodes
// which means our pointer cannot be either of those nodes, so we need to have a prev pointer that sits behind the pair
// but since the head has no prev, we can use a dummy node that points to head first
// since we now have prev, we can simply update the prev.next and prev.next.next
// every loop, we just need rmb to update the prev by 2 steps so we can continue to work on the following pair