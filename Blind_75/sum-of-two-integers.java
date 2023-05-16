// 371. Sum of Two Integers
// https://leetcode.com/problems/sum-of-two-integers/

class Solution {
    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

// Iterate till there is no carry
// Carry now contains common -> set bits of x and y
// Sum of bits of x and y where at least one of the bits is not set
// Carry is shifted by one so that adding it to x gives the required sum