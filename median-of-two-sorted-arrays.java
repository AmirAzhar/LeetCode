// https://leetcode.com/problems/median-of-two-sorted-arrays/

// Java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0, right = m;

        while (left <= right) {
            int p1 = (left + right) / 2;
            int p2 = (m + n + 1) / 2 - p1;

            int nums1MaxLeft = p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
            int nums1MinRight = p1 == m ? Integer.MAX_VALUE : nums1[p1];

            int nums2MaxLeft = p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1];
            int nums2MinRight = p2 == n ? Integer.MAX_VALUE : nums2[p2];

            if (nums1MaxLeft <= nums2MinRight && nums2MaxLeft <= nums1MinRight) {
                if ((m + n) % 2 == 0) return (Math.max(nums1MaxLeft, nums2MaxLeft) + Math.min(nums1MinRight, nums2MinRight)) / 2.0;
                else return Math.max(nums1MaxLeft, nums2MaxLeft);
            }

            else if (nums1MaxLeft > nums2MinRight) right = p1 - 1;

            else left = p1 + 1;
        }

        return 0.0;
    }
}

// brute force would be to combine both arrays and then take the middle -> O(m + n)
// O(log (m+n)) hints the use of binary search
// i want to find a partition for each array

// we define the partitions p1 and p2 to be the first element of the right partition
// we use binary search to find the correct partition for nums1 -> p1
    // init as (left + right) / 2
// partition of nums2 is derived basedon nums1 -> p2
    // since in a combined array, a single side can have (m + n + 1) / 2 elements -> +1 for case of odd
    // since there will alr be p1 elements on the left
    // init as (m + n + 1) / 2 - p1
// binary search condition is based on
    // arr1MaxLeft <= arr2MinRight
    // arr2MaxLeft <= arr1MinRight
// if fulfilled
    // if size is even -> take max of left and min of right and get ave
    // if odd -> take max of left
// if arr1MaxLeft > arr2MinRight
    // to many elements on the right of p1
    // so we need to move the p1 partition to the right
    // reduce search size to the right of the current p1
    // move left to after p1
// if arr2MaxLeft > arr1MinRight
    // to many elements on the right of p1
    // so we need to move the p1 partition to the right
    // reduce search size to the right of the current p1
    // move left to after p1


