// 134. Gas Station
// https://leetcode.com/problems/gas-station/description/

var canCompleteCircuit = function (gas, cost) {
  let totalTank = 0;
  let currentTank = 0;
  let startingStation = 0;
  for (let i = 0; i < gas.length; i++) {
    // We keep track of the net cost of travelling to a gas station
    const netCost = gas[i] - cost[i];
    totalTank += netCost;
    currentTank += netCost;

    // If the tank left is -ve, we need to reset
    // i.e. we are going to another gas station as a starting point
    if (currentTank < 0) {
      startingStation = i + 1;
      currentTank = 0;
    }
  }

  // If the total cost > total gas, means that it is impossible
  return totalTank < 0 ? -1 : startingStation;
};
