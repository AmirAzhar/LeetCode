// 1531. String Compression II
// https://leetcode.com/problems/string-compression-ii/description/

var getLengthOfOptimalCompression = function (s, k) {
  // Create a memo, where the key is ${i}_${lastChar}_${lastCharCount}_${k} and the value is the length for that key
  const memo = new Map();

  /**
   * backtrack function visits every possible options (delete or keep) at every point of the string, to find the best possible solution
   *
   * @param i The index of the string to visit next
   * @param prevChar The last character that was visited in the string
   * @param prevCharCount A running count for the prevChar that was visited
   * @param k Number of replacements allowed
   */

  const backtrack = (i, prevChar, prevCharCount, k) => {
    // Base Case: Run out of replacements, assign its value to be a v high number to indicate that it is not the correct solution
    if (k < 0) return Number.MAX_SAFE_INTEGER;

    // Base Case: End of string
    if (i >= s.length) return 0;

    // Create a key based on the input
    const key = `${i}_${prevChar}_${prevCharCount}_${k}`;

    // Check if value already exists in the memo
    if (key in memo) return memo[key];

    // Case 1: If the current char in the string is the same as the prev char, the count of the char increases and we move on to the next char in the string
    // We also need to consider the case when the prev count is 9 or 99 as the length will also increase when the number increases to 10 or 100
    // Also need to rmb that we are not adding 1 after single chars
    if (s[i] === prevChar) {
      if (prevCharCount == 9 || prevCharCount == 99 || prevCharCount == 1)
        memo[key] = 1 + backtrack(i + 1, prevChar, prevCharCount + 1, k);
      else memo[key] = backtrack(i + 1, prevChar, prevCharCount + 1, k);
    } else {
      // Case 2: If the chars are different, we have 2 choices - keep or delete the char. We have tho take the min of both these options.
      // if we keep, we must add 1 to the length of the key
      // if we delete, we do not need to increment the length, but the number of replacements, k, we can make, decreases.
      memo[key] = Math.min(
        1 + backtrack(i + 1, s[i], 1, k),
        backtrack(i + 1, prevChar, prevCharCount, k - 1)
      );
    }
    return memo[key];
  };
  return backtrack(0, "", 0, k);
};
