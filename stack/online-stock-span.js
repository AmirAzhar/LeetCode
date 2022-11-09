// 901. Online Stock Span
// https://leetcode.com/problems/online-stock-span/

var StockSpanner = function () {
  // Using a stack to store the stock information
  // Each element is of the form {price, span} for a current stock
  this.stack = [];
};

StockSpanner.prototype.next = function (price, span = 1) {
  // While they are elements in the stack, and the price of the last element is lesser than the new price
  // Update the span by adding on top of the prev span

  while (
    this.stack.length &&
    this.stack[this.stack.length - 1].price <= price
  ) {
    let prevSpan = this.stack.pop().span;
    span += prevSpan;
  }

  this.stack.push({ price, span });

  return span;
};
