// 38. Count and Say
// https://leetcode.com/problems/count-and-say/description/

const countAndSay = function(n) {
	if (!n) return '1';

    // Recursively solve the substring
    return solve(n, '0');
};

const solve = function(n, str) {
    // Shorten the string for every call until u reach an empty string
    if (n--) {
        // Base Case: empty string
        if (str == '0') return solve(n, '1');
        let res = '';

        // Iterate through string
        for (let i = 0; i < str.length; i++) {

            // Keep running count of consecutive same numbers
            let currentCount = 1;
            while (str[i] === str[i + 1]) {
                currentCount++;
                i++;
            }

            // Add on to the res
            res += `${currentCount}${str[i]}`
        }
        
        // Update the string
        str = res;

        // Recursive call
        return solve(n, str);
    }
    return str;
}