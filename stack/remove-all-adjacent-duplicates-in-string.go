// 1047. Remove All Adjacent Duplicates In String
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
func removeDuplicates(s string) string {
    stack := make([]rune, 0, len(s))
    for _, ch := range s {
        if len(stack) > 0 && stack[len(stack) - 1] == ch { 
            stack = stack[:len(stack) - 1] 
        } else { 
            stack = append(stack, ch) 
        }
    }
    return string(stack)
}