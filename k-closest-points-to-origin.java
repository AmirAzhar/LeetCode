// https://leetcode.com/problems/k-closest-points-to-origin/description/

// Java
class Solution {
    private int calcDistance(int[] point) {
            return point[0] * point[0] + point[1] * point[1]; 
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(calcDistance(b), calcDistance(a)));

        for (int[] p : points){
            maxHeap.add(p);
            if(maxHeap.size() > k) maxHeap.poll();
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) result[index++] = maxHeap.poll();
        

        return result;

    }
}

// JS
var kClosest = function(points, k) {
    const calcDistance = (point) => {
        return point[0] * point[0] + point[1] * point[1];
    };

    const maxHeap = new MaxPriorityQueue({ 
        compare: (a, b) => calcDistance(b) - calcDistance(a) 
    });

    for (const point of points) {
        maxHeap.enqueue(point);

        if (maxHeap.size() > k) {
            maxHeap.dequeue();
        }
    }

    return maxHeap.toArray();
};

// use a maxheap to ensure the points are sorted based on distance