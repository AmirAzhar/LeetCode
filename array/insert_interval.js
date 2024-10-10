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

// Time: O(n) -> iterate the array once
// Space: O(n) -> stack holds at most n + 1 intervals

// init a stack
// iterate through intervals
// if newInterval starts after currInterval -> no overlap
//      just push the currInterval to the stack
// if newInterval ends before the currInterval -> no overlap
//      but newInterval is being pushed first
//      newInterval updated to currInterval
// last case if there is an overlap
//      merge the intervals by taking min of starts and max of ends
// after lopp finishes, there will be 1 last unmerged interval, so need to add that
