// https://leetcode.com/problems/trapping-rain-water/submissions/1552387540/

// Java
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = max;
            max = Math.max(height[i], max);
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(height[i], max);
        }

        for (int i = 0; i < height.length; i++) {
            int water = Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
            res += water;
        }

        return res;
        
    }
}

// at any point, the height of the water a is calculated as 
    // min of highst point to its left lh
    // and the higehst point to its right rh
    // minus current height - c
    // so a = min(lh, rh) - c
// to get lh and rh, we can do this iteratively
    // lh -> from left to right
    // rh -> from right to left