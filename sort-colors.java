// https://leetcode.com/problems/sort-colors/description/

// Java
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0; // points to where the next 0 should go
        int two = nums.length - 1; // points to where the next two should go
        int one = 0; // main iterator

        while (one <= two){
            if (nums[one] == 0) {
                swap(nums, zero++, one++);
            }
            else if (nums[one] == 1){
                one++;
            }
            else {
                swap(nums, one, two--); // dont increment one because need check
            }
        }
    }

    public void swap (int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//JS
var sortColors = function(nums) {

    function swap (i, j){
        let temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    let zero = 0, one = 0, two = nums.length - 1;

    while (one <= two){
        if (nums[one] == 0) swap(zero++, one++);
        else if (nums[one] == 1) one++;
        else swap(one, two--);
    }
};

// the array needs to be sorted in 0 1 2 -> essentially incrasing order
// technically i can create my own sorting algorithm
// but easier to do in 2 pass
    // 1st pass to count
    // 2nd pass to replace the values
// or i can use 3 pointers
    // zero -? Where the next 0 should go.
    // one -> The current element being checked.
    // two -> Where the next 2 should go.
// Loop through the array (one <= two):
    // If 0 -> Swap with zero and move both zero & one forward.
    // If 1 -> Already in the right place, just move one forward.
    // If 2 -> Swap with two and move two backward (but recheck one).
