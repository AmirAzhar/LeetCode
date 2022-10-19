// 1335. Minimum Difficulty of a Job Schedule
// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/description/

var minDifficulty = function (jobDifficulty, d) {
  // Not enough jobs
  if (jobDifficulty.length < d) return -1;

  // DP memo where key is the start index and # days, value is max of curr job + min of all later days
  const memo = {};

  // We want to return the minimum total difficulty for each starting index
  // corresponding to each number of days left
  const dfs = (start, numDays) => {
    // Check if we have reached the end of all days
    if (numDays === d) return start === jobDifficulty.length ? 0 : Infinity;

    // Create key and check in memo
    const key = `${start}-${numDays}`;
    if (key in memo) return cache[key];

    // calculate the last index for this day's number
    // if we go beyond that index we will have more days than jobs
    const end = jobDifficulty.length - d + numDays;

    // result will hold the minimum total of all following days
    let result = Infinity;
    // max will hold the max for the current day
    let max = -Infinity;

    // iterate through the jobs updating the max and searching the remainder
    // of jobs and days
    for (let i = start; i <= end; i++) {
      max = Math.max(max, jobDifficulty[i]);
      result = Math.min(result, max + dfs(i + 1, numDays + 1));
    }

    // save the result in the cach and return it;
    return (memo[key] = result);
  };
  return dfs(0, 0);
};
