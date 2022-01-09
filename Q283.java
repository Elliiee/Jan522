/*
283 Move Zeroes
Given an integer array nums, move all 0s to the end of it while maintaining the relative order
of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
 */
public class Q283 {
    public void moveZeros(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++){
            nums[index++] = 0;
        }
    }
}
