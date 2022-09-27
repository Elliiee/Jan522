import java.util.ArrayList;
import java.util.List;

public class ArraysAndStrings {
    /*
    Example 1: return true if a given string is a palindrome, false otherwise
     */
    public boolean checkIfPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    /*
    Example 2: given a sorted array of unique integers and a target integer
    ,return true if there exists a pair of numbers that sum to the target.
    False otherwise.
     */
    public boolean checkForTarget(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int curr = nums[left] + nums[right];
            if (curr == target)
                return true;

            if (curr > target)
                right--;
            else
                left++;
        }
        return false;
    }

    /*
    Another method is both pointers start from index 0.
    Example 3: given two sorted integer arrays, return an array that
    combines both of them and is also sorted.
     */
    public List<Integer> combine(int[] arr1, int[] arr2){
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j])
                ans.add(arr1[i++]);
            else
                ans.add(arr2[j++]);
        }

        while (i < arr1.length)
            ans.add(arr1[i++]);
        while (j < arr2.length)
            ans.add(arr2[j++]);

        return ans;
    }

    /*
    Sliding Window

     */


    /*
    Use StringBuilder O(1) and then convert to a string
     */
    public String buildString(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
