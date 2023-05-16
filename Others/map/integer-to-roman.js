// 12. Integer to Roman
// https://leetcode.com/problems/integer-to-roman/description/

var intToRoman = function (N) {
  const map = {
    M: 1000,
    CM: 900,
    D: 500,
    CD: 400,
    C: 100,
    XC: 90,
    L: 50,
    XL: 40,
    X: 10,
    IX: 9,
    V: 5,
    IV: 4,
    I: 1,
  };

  let res = "";

  // Since roman numerals only have the biggest numbers appearing from the front, we can iterate through the mapping from largest to smallest
  for (const [key, value] of Object.entries(map)) {
    // As long as our current number is larger than the current roman:value
    while (N >= value) {
      // Append the roman symbol to the res
      res += key;
      // Decrement the value
      N -= value;
    }
  }
  return res;
};
