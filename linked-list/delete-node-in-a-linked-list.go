// 237. Delete Node in a Linked List
// https://leetcode.com/problems/delete-node-in-a-linked-list/description/

func deleteNode(node *ListNode) {
	node.Val, node.Next = node.Next.Val, node.Next.Next
}