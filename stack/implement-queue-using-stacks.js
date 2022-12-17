// 232. Implement Queue using Stacks
// https://leetcode.com/problems/implement-queue-using-stacks/description/

var MyQueue = function () {
  this.stack1 = [];
  this.stack2 = [];
};

MyQueue.prototype.shiftStacks = function () {
  if (this.stack2.length === 0) {
    while (this.stack1.length > 0) {
      this.stack2.push(this.stack1.pop());
    }
  }
};

/**
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
  this.stack1.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function () {
  this.shiftStacks();
  return this.stack2.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function () {
  this.shiftStacks();
  return this.stack2[this.stack2.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
  return this.stack1.length === 0 && this.stack2.length === 0;
};

// The shiftStacks function is used to move elements from stack1 to stack2 in order to maintain the FIFO order of the queue. The peek and pop functions call shiftStacks to ensure that the element at the front of the queue is at the top of stack2, which allows us to return or remove it. The push function simply adds the element to the top of stack1. The empty function returns true if both stacks are empty, and false otherwise.
