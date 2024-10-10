// 57. Insert Interval
// https://leetcode.com/problems/insert-interval/description/

/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function (intervals, newI) {
  const stack = [];

  for (const currI of intervals) {
    if (newI[0] > currI[1]) stack.push(currI);
    else if (newI[1] < currI[0]) {
      stack.push(newI);
      newI = currI;
    } else newI = [Math.min(newI[0], currI[0]), Math.max(newI[1], currI[1])];
  }

  stack.push(newI);

  return stack;
};

// Time complexity: O(n) -> We iterate over the array of intervals once.
// Space complexity: O(n) -> The stack holds at most n + 1 intervals, where n is the number of original intervals.

// Initialize an empty stack to hold the resulting intervals.
// Iterate through the intervals one by one:
// - If newInterval starts after the current interval ends (no overlap), push the current interval to the stack.
// - If newInterval ends before the current interval starts (no overlap), push newInterval first, then update newInterval to be the current interval.
// - If there's overlap between newInterval and the current interval, merge them by taking the minimum start time and maximum end time.
// After the loop finishes, the last interval (newInterval) will need to be pushed to the stack since it hasn't been added yet.
