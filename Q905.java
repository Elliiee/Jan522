public class Q905 {
    // sort array by parity
    // left is even number, right is odd number
    // you can change the order of the old array, as long as they are odd after even
    public int[] sortArrayByParity(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            if (nums[left] % 2 > nums[right] % 2){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if (nums[left] % 2 == 0){
                left++;
            }
            if (nums[right] % 2 == 1){
                right--;
            }
        }
        return nums;
    }
}
