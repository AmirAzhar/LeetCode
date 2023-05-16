// 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;

        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * Math.abs(left - right), max);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;
    }
}

// Brute Force
// 2 pointers to get the volume for every possible pair

// Optimized
// Greedy by calculating volume with the largest width first - pointers starting
// at opposite ends
// Update the max if current volums is higher
// Shift the pointer of whichever wall is lower
