// 739. Daily Temperatures
// https://leetcode.com/problems/daily-temperatures/description/

function dailyTemperatures(temperatures) {
  // create an array to store the number of days to wait for a warmer temperature
  const waitingDays = new Array(temperatures.length).fill(0);

  // create a stack to store the indices of the temperatures array
  const stack = [];

  // iterate through the temperatures array
  for (let i = 0; i < temperatures.length; i++) {
    // while the stack is not empty and the current temperature is warmer than the temperature at the top of the stack
    while (
      stack.length > 0 &&
      temperatures[i] > temperatures[stack[stack.length - 1]]
    ) {
      // pop the top element from the stack
      const index = stack.pop();
      // update the number of days to wait for a warmer temperature at the popped index
      waitingDays[index] = i - index;
    }
    // push the current index to the stack
    stack.push(i);
  }

  // return the array of waiting days
  return waitingDays;
}
