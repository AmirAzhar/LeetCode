// https://leetcode.com/problems/k-closest-points-to-origin/description/

/**
 * @param {number[][]} points
 * @param {number} k
 * @return {number[][]}
 */
var kClosest = function (points, k) {
  let dist = ([x, y]) => x * x + y * y;

  let maxHeap = new PriorityQueue((a, b) => dist(b) - dist(a));

  for (let point of points) {
    maxHeap.enqueue(point);
    if (maxHeap.size() > k) maxHeap.dequeue();
  }

  return maxHeap.toArray();
};

// Time: O(nlogk) -> n elemenets and we enqueue/dequeue each ele at least once which takes logk time
// Space: O(k) -> maxHeap as at most k elements

// i can use a minheap but ill use a maxheap instead
// as i add the points into the heap, if the size is larger than k, i will dequeue 0> this removes the largest elements
// this allows me tio maintain a heap size of k (instead of using minheap then extracting first k later)
