// 155. Min Stack
// https://leetcode.com/problems/min-stack/description/

var MinStack = function () {
  this.stack = [];
  this.length = 0;
};

/**
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function (val) {
  this.stack.push([val, this.length ? Math.min(this.stack[this.length - 1][1], val) : val]);
  this.length++;
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
  this.stack.pop();
  this.length--;
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
  return this.stack[this.length - 1][0];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
  return this.stack[this.length - 1][1];
};

// cant keep a singuler variable for min since the min changes when a value is removed
// need to keep track of the min at that point of time
// each element in the array is a pair [value, min] where value is the new value added and the min is the min at the point
// the min at that point is the MIN of the new val and the min of the previous value
// then to get the min, always look at the min of the last element in the stack
