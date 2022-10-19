// 1832. Check if the Sentence Is Pangram
// https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/

func checkIfPangram(sentence string) bool {

    var seen [26]int
    count := 0

    for _, char := range sentence {
        seen[int(char - 'a')]++
        if (seen[int(char - 'a')] == 1){count++}
    }

    return count == 26
}