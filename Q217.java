import java.util.HashSet;

/*
217 Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
 */
public class Q217 {
    public boolean containsDuplicates(int[] nums){
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (numbers.contains(nums[i])){
                return true;
            } else {
                numbers.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 1};
        Q217 q = new Q217();
        System.out.println(q.containsDuplicates(nums));
    }
}
