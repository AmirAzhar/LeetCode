// 2244. Minimum Rounds to Complete All Tasks
// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

const minimumRounds = (tasks) => {
  let map = {};
  let res = 0;

  // Get the frequency of each integer in the array and store in the map where k:v is integer:value
  for (const task of tasks) map[task] = map[task] + 1 || 1;

  // Iterate through the map
  for (let [val, freq] of Object.entries(map)) {
    // If the integer only has 1 frequency, it will be impossible to complete the tasks => return -1
    if (freq < 2) return -1;
    // We will be greedy and complete the mac possible of tasks per round (3)
    res += Math.ceil(freq / 3);
  }

  return res;
};
