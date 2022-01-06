/*
189 rotate array
Given an array, rotate the array to the right by k steps, where k is non-negtive.
 */
public class Q189 {
    public void rotate(int[] nums, int k){
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
/*
The easiest solution would use additional memory and that is fine.
The actual trick comes when trying to solve it without using any additional memory. This means
you need to use the original array somehow to move the elements around. Now, we can place each
element in its original location and shift all the elements around it to adjust as that would
be too costly and most likely will time out on larger input arrays.

One line of thought is based on reversing the array or part of it to obtain the desired result.
Think about how reversal might potentially help us out by using an example.

1234567 k = 3
reverse 4321
reverse 765
4321765
reverse again 5671234 !!!!!
 */
