// 151. Reverse Words in a String
// https://leetcode.com/problems/reverse-words-in-a-string/description/

func reverseWords(s string) string {
	// split the given string into a slice of substrings separated by white spaces
	words := strings.Fields(s)

	// 2 pointers - front and back - and cntionually swap each other until the pointers cros
	for i, j := 0, len(words)-1; i < j; i, j = i+1, j-1 {
		words[i], words[j] = words[j], words[i]
	}

	// join the words back
	return strings.Join(words, " ")
}