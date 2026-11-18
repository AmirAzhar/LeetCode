// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

// Java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) heap.offer(num);

        for (int i = 0; i < k -1; i++) heap.poll();

        return heap.poll();
    }
}