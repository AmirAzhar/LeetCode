// https://leetcode.com/problems/container-with-most-water/description/

// Java
class Solution {
    public int maxArea(int[] height) {
       int l = 0, r = height.length - 1;
       int max = 0;

       while (l < r) {
        int lH = height[l], rH = height[r];
        max = Math.max(Math.min(lH, rH) * (r - l), max);
        if (lH > rH) r--;
        else l++;
       }

       return max;
    }
}

// JS
var maxArea = function(height) {
    let l = 0, r = height.length - 1, max = 0

    while (l < r){
        let lH = height[l], rH = height[r]
        max = Math.max(Math.min(lH, rH) * (r - l), max);
        lH > rH ? r-- : l++
    }

    return max
}