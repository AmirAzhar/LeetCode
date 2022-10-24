// 1239. Maximum Length of a Concatenated String with Unique Characters
// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

var maxLength = function (arr) {
  let res = 0;

  let solve = (start, curr) => {
    // The concatenation has duplicate chars, it is not a valid ans
    if (curr.length !== new Set(curr.split("")).size) return;

    // Update the max if current srting is longer
    res = Math.max(res, curr.length);

    // Recursively solve by concat the current string with the next string in the array
    for (let i = start; i < arr.length; i++) solve(i + 1, curr + arr[i]);
  };

  solve(0, "");

  return res;
};
