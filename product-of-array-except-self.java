// https://leetcode.com/problems/product-of-array-except-self/submissions/1519946340/

// Java
class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] res = new int[nums.length];

       int product = 1;

       for (int i = 0; i < nums.length; i++){
            res[i] = product;
            product *= nums[i];
       } 

        product = 1;
        
       for (int i = nums.length - 1; i >= 0; i--){
            res[i] *= product;
            product *= nums[i];
       } 

       return res;
    }
}

// JS
var productExceptSelf = function(nums) {
    let res = []

    let product = 1
    for (let i = 0; i < nums.length; i++){
        res[i] = product
        product *= nums[i]
    }

    product = 1
    for (let i = nums.length - 1; i >=0; i--){
        res[i] *= product
        product *= nums[i]
    }

    return res
};

// to calculate product of elements except itself
// need get product of all elements to the left * all elements to the right
// to do this, you can calculate the prefix/sufix sum