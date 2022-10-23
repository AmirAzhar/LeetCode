// 219. Contains Duplicate II
// https://leetcode.com/problems/contains-duplicate-ii/

func containsNearbyDuplicate(nums []int, k int) bool {
	m := make(map[int]int)

	for idx, num := range nums {
		_, exist := m[num]
		if exist && (idx-m[num]) <= k {
			return true
		}
		m[num] = idx
	}
	return false
}