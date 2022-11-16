public class Q31 {
    /*
    31 Next Permutation
    The replacement must be in place and use only constant extra memory.
     */
    public void nextPermutation(int[] nums){
        int i = nums.length - 2;
        //find first decreasing number
        while (i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            //find number just larger than nums[i]
            while (nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        //reverse the elements from i + 1 to the end
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start){
        int i = start, j = nums.length - 1;
        while (i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
