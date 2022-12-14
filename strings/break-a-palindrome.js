// 1328. Break a Palindrome
// https://leetcode.com/problems/break-a-palindrome/

var breakPalindrome = function (palindrome) {
  // Base Case
  if (palindrome.length <= 1) return "";

  // Convert into an array for easy traversal and finding
  const arr = palindrome.split("");

  // Unlike other palindrome qns that have 2 cases (even/odd), using a midpoint makes it easier,
  // We also dont need to check if it is a palindrome
  const mid = Math.floor(palindrome.length / 2);

  // iterate through the first half of the array
  for (let i = 0; i < mid; i++) {
    // for any char we come across first that is not a, we set ut to as (lexi smaller)
    if (arr[i] !== "a") {
      arr[i] = "a";
      return arr.join("");
    }
  }

  // SPECIAL CASE: if a string is all a
  arr[palindrome.length - 1] = "b";

  return arr.join("");
};
