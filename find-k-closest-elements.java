// https://leetcode.com/problems/find-k-closest-elements/

// Java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a - x) == Math.abs(b - x)) return a - b;
            else return Math.abs(a - x) - Math.abs(b - x); 
        });
        List<Integer> res = new ArrayList<>();

        for (int num : arr) pq.offer(num);
        for (int i = 0; i < k; i++) res.add(pq.poll());

        Collections.sort(res);

        return res;
    }
}