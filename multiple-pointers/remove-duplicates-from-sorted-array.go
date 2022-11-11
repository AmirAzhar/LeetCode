// 26. Remove Duplicates from Sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

func removeDuplicates(nums []int) int {
	// Base Case: Less than 2 elements
	if len(nums) < 2 {
		return 1
	}

	slow := 0
	fast := 1

	for fast < len(nums) {
		if nums[fast] == nums[slow] {
			fast++
		} else {
			slow++
			nums[slow] = nums[fast]
		}
	}

	return slow + 1
}