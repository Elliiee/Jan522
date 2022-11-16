import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q128 {
    /*
    128 Longest Consecutive Sequence
    Given an unsorted array of integers nums, return the length of the longest
    consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive
    elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     */

    //Approach 1 sort
    //But the Time complexity : O(nlgn) is longer than the constraints O(n)
    //not the correct answer
    //though it's easy to understand;
    public int longestConsecutive(int[] nums){
        //If the array is empty, return 0;
        if (nums.length == 0) return 0;

        Arrays.sort(nums); //Time complexity : O(nlgn)

        int longestLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++){
            //If the current number and the previous are equal, move on to the next one.
            if (nums[i] != nums[i-1]){
                //Check if the current number is consecutive or not
                if (nums[i] == nums[i-1] + 1){
                    currentLength++;
                } else {
                    longestLength = Math.max(longestLength, currentLength);
                    currentLength = 1; // reset for the next try
                }
            }
        }

        //the last element could be included in the longest
        // so compare again to check at the end
        return Math.max(longestLength, currentLength);
    }

    public int longestConsecutiveII(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int n : nums){
            set.add(n);
        }

        int longest = 0;

        for (int n : set){
            if (!set.contains(n - 1)){
                int current = n;
                int currentLength = 1;

                while (set.contains(current + 1)){
                    current++;
                    currentLength++;
                }

                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }
}
