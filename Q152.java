public class Q152 {
    /*
    152 Maximum Product Subarray
    Given an integer array nums, find a subarray that has the largest product, and return
    the product.
    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.
    Don't get the question int the wrong way. It is asking for a consecutive sequence
    product of a sub-array. Not just 2 random numbers.
     */

    /*
    1. Zeros
    You will have to restart your product chain after the zero.

    2. Negative numbers
    This ia a bit tricky.
    a. If you encounter 2 negative numbers, your product can still be the largest.
    b. But, if there is a 0 in between of the 2 negative numbers, it won't work.

    So here, they keep track of both max product and min product.
    The min product is for handling the negative numbers.

    1. current number
    This value will be picked if the accumulated product has been bad.
    This can happen when the current number has a preceding zero, or is
    preceded by a single negative number

    2. max_so_far
    This value will be picked if the accumulated product has been increasing

    3. min_so_far
    This value will be picked if the current number is negative and the combo chain
    has been disrupted by a single negative number before.

     */

    public int maxProduct(int[] nums){
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++){
            int current = nums[i];

            int temp_max = Math.max(current,
                    Math.max(max_so_far * current, min_so_far * current));

            min_so_far = Math.min(current,
                    Math.min(max_so_far * current, min_so_far * current));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }
        return result; 
    }
}
