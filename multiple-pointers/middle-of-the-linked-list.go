// 876. Middle of the Linked List
// https://leetcode.com/problems/middle-of-the-linked-list/description/

func middleNode(head *ListNode) *ListNode {

	fast, slow := head, head

	for fast != nil {

		fast = fast.Next

		if fast != nil {
			fast = fast.Next

		} else {
			break
		}

		slow = slow.Next
	}

	return slow

}