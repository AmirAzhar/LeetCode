package strings;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPtr = 0, tPtr = 0;

        char sMap[] = s.toCharArray();
        char tMap[] = t.toCharArray();

        if (s.length() < 1)
            return true;

        while (tPtr < t.length() && sPtr < s.length()) {
            if (tMap[tPtr] == sMap[sPtr])
                sPtr++;
            tPtr++;
        }

        return sPtr == s.length();

    }
}
