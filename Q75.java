public class Q75 {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;

        int start = 0, end = nums.length - 1, currentIndex = 0;
        while (start < end && currentIndex <= end){
            if (nums[currentIndex] == 0){
                nums[currentIndex] = nums[start];
                nums[start] = 0;
                start++;
                currentIndex++;
            } else if (nums[currentIndex] == 2){
                nums[currentIndex] = nums[end];
                nums[end] = 2;
                end--; // don't increase currentIndex here
                // because after the switch you need to compare the number again
                // the previous nums[end] number is unknow, compare again
            } else {
                currentIndex++;
            }
        }
    }
}
