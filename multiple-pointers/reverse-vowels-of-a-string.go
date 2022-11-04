// 345. Reverse Vowels of a String
// https://leetcode.com/problems/reverse-vowels-of-a-string/description/

func isVowel(c rune) bool {
	c = unicode.ToLower(c)
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}

func reverseVowels(s string) string {
	ss := []rune(s)
	n := len(ss)
	l, r := 0, n-1
	for l < r {

		for l < r && !isVowel(ss[l]) {
			l += 1
		}

		for r > l && !isVowel(ss[r]) {
			r -= 1
		}

		ss[l], ss[r] = ss[r], ss[l]

		l += 1

		r -= 1
	}
	return string(ss)
}