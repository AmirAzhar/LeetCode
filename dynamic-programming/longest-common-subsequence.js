// 1143. Longest Common Subsequence
// https://leetcode.com/problems/longest-common-subsequence/description/

function longestCommonSubsequence(text1, text2) {
  // Create a 2D array to store the lengths of the common subsequences of
  // the substrings of text1 and text2.
  const dp = Array(text1.length + 1)
    .fill(null)
    .map(() => Array(text2.length + 1).fill(0));

  // Iterate through the substrings of text1 and text2, updating the values in
  // the dp array as we go.
  for (let i = 1; i <= text1.length; i++) {
    for (let j = 1; j <= text2.length; j++) {
      // If the characters at the current index in both text1 and text2 are the
      // same, this means that we can extend the common subsequence by one
      // character.
      if (text1[i - 1] === text2[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1;
      } else {
        // Otherwise, the common subsequence will be the longer of the common
        // subsequences of the substrings of text1 and text2 without their last
        // characters.
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
  }

  // The length of the longest common subsequence is the value in the bottom
  // right corner of the dp array.
  return dp[text1.length][text2.length];
}
