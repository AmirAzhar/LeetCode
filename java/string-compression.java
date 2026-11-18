// https://leetcode.com/problems/string-compression/description/

// Java
class Solution {
    public int compress(char[] chars) {
        int count = 1, ptr = 0;

        for (int i = 1; i <= chars.length; i++)
            if (i < chars.length && chars[i] == chars[i-1]) count++;
            else {
                chars[ptr++] = chars[i - 1];
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) chars[ptr++] = c;
                }
                count = 1;
        }

        return ptr;
    }
}

// i will iterate through the chars
// i keep a counter
// will keep a pointer
// if the curr == prev char
    // increment
// if not
    // start putting at the pointer
