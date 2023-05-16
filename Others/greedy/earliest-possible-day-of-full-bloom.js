// 2136. Earliest Possible Day of Full Bloom
// https://leetcode.com/problems/earliest-possible-day-of-full-bloom/description/

var earliestFullBloom = function (plantTime, growTime) {
  // 1) Create an array of pairs, where each pair represents the plantTime and growTime of a plant [plantTime, growTime]
  // 2) Sort the array based on decreasing grow time. Since grow time can be overlapped, we can start with the plants with the longer grow times.
  // 3) Using a greedy approach, to iterate through flowers starting from the slowest growing ones
  //    a) Add plant time
  //    b) // Update the maxTime if the currTime is now higher after including the grow time

  let currTime = 0;

  return plantTime
    .map((e, i) => [e, growTime[i]])
    .sort((a, b) => b[1] - a[1])
    .reduce((prev, curr) => {
      currTime += curr[0];
      return Math.max(prev, currTime + curr[1]);
    }, 0);
};
