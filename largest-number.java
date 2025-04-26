// https://leetcode.com/problems/largest-number/description/

// Java
class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++) str[i] = nums[i] + "";

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", just return "0" (to handle the case where all numbers are 0)
        if (str[0].equals("0")) return "0";
        

        // Join the sorted array into a single string - faster than String.join
        StringBuilder result = new StringBuilder();
        for (String num : str) result.append(num);
        
        return result.toString();
    }
}

// Sorting alphabetically alone is not sufficient
// We need a custom comparator to determine the order based on concatenated values
    // rule of thumb that if u want descending, b - a
// The logic for comparison:
    // If the numbers are of the same length, compare them lexicographically
    // If the numbers have different lengths, compare the two possible concatenations:
        // Concatenate s1 + s2 and s2 + s1
        // If s1 + s2 is larger, s1 should come before s2
        // If s2 + s1 is larger, s2 should come before s1

