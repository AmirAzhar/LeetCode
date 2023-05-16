// 452. Minimum Number of Arrows to Burst Balloons
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

var findMinArrowShots = function (points) {
  // We can be greedy by sorting the balloons based on the left edge of the balloon
  points.sort((a, b) => a[0] - b[0]);
  let prevY = null,
    count = 0;

  // Iterate through each balloon
  for (let [currX, currY] of points) {
    // If the current balloon left edge is greater than right edge of the previous balloon, we need another arrow
    // We then update the previous left edge before moving to the next balloon
    if (prevY == null || prevY < currX) {
      count++;
      prevY = currY;
    }
    // If there is already an overlap, the previous left edge should be updated if the curr left edge is smaller
    else prevY = Math.min(prevY, currY);
  }
  return count;
};
