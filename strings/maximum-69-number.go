// 1323. Maximum 69 Number
// https://leetcode.com/problems/maximum-69-number/description/

func maximum69Number(num int) int {
	r, _ := strconv.Atoi((strings.Replace(strconv.Itoa(num), "6", "9", 1)))
	return r
}