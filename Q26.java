public class Q26 {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] != nums[i]){
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }

    public static void main(String[] args){
        int[] nums = {1, 1, 2, 2, 3};
        Q26 q = new Q26();
        int ans = q.removeDuplicates(nums);
        System.out.print(ans);
    }
}
