// 76. Minimum Window Substring
// https://leetcode.com/problems/minimum-window-substring/

var minWindow = function (s, t) {
  // Map used to keep track of the frequency of each character required from string t
  const charMap = {};
  for (let char of t) charMap[char] = (charMap[char] || 0) + 1;

  // Use a sliding window technique with 2 pointers l and r
  let l = (r = 0);

  // remLength keeps track of the number of chars left we have to include in the substring
  let remLength = Object.keys(charMap).length;
  let res = "";

  while (r < s.length) {
    const rC = s[r];

    // If the char is in the map, we decrement its freq
    charMap[rC]--;

    // Once the freq has hit 0, it means that there is 1 less char to keep track of
    if (charMap[rC] === 0) remLength--;

    // Once the remLength has hit 0, it means that we have reach a solution
    while (remLength === 0) {
      const lC = s[l];

      // We need to adjust the substring by moving the left pointer
      if (!res || res.length > r - l + 1) res = s.slice(l, r + 1);

      // As we move the left pointer, if the char is the map and prev has no freq left, we increment the remLength since we are removing that char from our substring now
      if (charMap[lC] === 0) remLength++;

      // We also need to increase the freq of the char that we have left
      charMap[lC]++;

      l++;
    }
    r++;
  }

  return res;
};
