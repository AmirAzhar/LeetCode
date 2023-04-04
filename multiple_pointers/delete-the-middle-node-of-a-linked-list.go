// 2095. Delete the Middle Node of a Linked List
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
func deleteMiddle(head *ListNode) *ListNode {

	if head.Next == nil {
		return nil
	}
	slow, fast := head, head.Next

	for fast.Next != nil && fast.Next.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}

	slow.Next = slow.Next.Next
	return head
}