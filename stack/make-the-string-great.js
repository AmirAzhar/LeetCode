// 1544. Make The String Great
// https://leetcode.com/problems/make-the-string-great/description/

var makeGood = function (s) {
  let stack = [""];

  for (const char of s) {
    let top = stack[stack.length - 1];
    if (top != char && top.toLowerCase() == char.toLowerCase()) stack.pop();
    else stack.push(char);
  }
  return stack.join("");
};
