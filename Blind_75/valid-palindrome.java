// 125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/description/

class Solution {
    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (s.length() < 2)
            return true;

        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}

// Remove all non alphanumeric and convert entire string into lowercase
// useing 2 pointers - 1 at the start and 1 at the end, iterate through the
// string
// comapre both characters
// if both chars are not the same, immediately is not a palindrome
