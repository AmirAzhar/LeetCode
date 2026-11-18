// https://leetcode.com/problems/3sum/

// Java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 3) return res;

        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r){
                int sum = nums[l] + nums[r] + nums[i];

                if (sum == 0) {
                    res.add(new ArrayList(Arrays.asList(nums[l], nums[r], nums[i])));
                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
                else if (sum > 0) r--;
                else l++;
            }
        }

        return res;
    }
}


// JS
var threeSum = function(nums) {
    let res = [];
    if (nums.length < 3) return res;

    nums = nums.sort((a,b) => a-b)

    for (let i = 0; i < nums.length - 1; i++){
        // ignore duplicate i
        if (i && nums[i] == nums[i - 1]) continue;

        let l = i + 1, r = nums.length - 1;

        while (l < r){
            let sum = nums[l] + nums[i] + nums[r];
            if (sum == 0){
                res.push([nums[l], nums[r], nums[i]]);
                l++, r--;

                // ignore duplicate l and r
                while (l < r && nums[l] == nums[l - 1]) l++;
                while (l < r && nums[r] == nums[r + 1]) r--;
            }
            else if (sum > 0) r--;
            else l++;
        }
    }

    return res;
};

// we need check all possible tripletes
// iterate through the array with i as the main element
    // ignore duplicate i;
// use left and right pointers
    // check sum === 0
        // add the array into res
        // update l and r until it is not duplicate
    // if sum > 0, need decrese the right
    // if sum < 0, need increase the left