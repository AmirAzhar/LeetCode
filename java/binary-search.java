// https://leetcode.com/problems/binary-search/description/

// Java
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r){
            int mid = (l + r) / 2;
            int num = nums[mid];

            if (num == target) return mid;
            else if (num > target) r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }
}

//JS
var search = function(nums, target) {
    let l = 0, r = nums.length - 1;

    while (l <= r){
        let mid = Math.floor((l + r) / 2);
        let num = nums[mid];

        if (num == target) return mid;
        else if (num > target) r = mid - 1;
        else l = mid + 1;
    }

    return -1;
};