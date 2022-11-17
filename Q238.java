public class Q238 {
    /*
    238. Product of Array Except Self
    Given an integer array nums, return an array answer such asnwer[i] is equal to the
    product of all the elements of nums except nums[i];
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time
    and without using the division operation.
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
     */

    /*
    Approach 1 left and right product lists
    Built 2 arrays: one to store the product of the left, the other to store the product
    of all the right elements. And then multiply them to get the answer for each.
     */
    public int[] productExceptSelf(int[] nums){
        int length = nums.length;

        //build 2 arrays to get the left product and right product except itself
        int[] leftProduct = new int[length];
        int[] rightProduct = new int[length];

        //final answer array to be returned
        int[] answer = new int[length];

        //for index 0, there is no left product, so it should be 1
        leftProduct[0] = 1;
        for (int i = 1; i < length; i++){
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
        }

        //for last element, there is no right product, so it should be 1
        rightProduct[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--){
            rightProduct[i] = nums[i + 1] + rightProduct[i + 1];
        }

        for (int i = 0; i < length; i++){
            answer[i] = leftProduct[i] * rightProduct[i];
        }

        return answer;
    }
}
