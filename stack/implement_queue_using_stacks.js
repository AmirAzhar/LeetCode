// 232. Implement Queue using Stacks
// https://leetcode.com/problems/implement-queue-using-stacks/description/

var MyQueue = function () {
  this.stack = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
  this.stack.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function () {
  const ele = this.stack.shift();
  return ele;
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function () {
  return this.stack[0];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
  return !this.stack.length;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
