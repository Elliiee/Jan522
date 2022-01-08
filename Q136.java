/*
136 Single Number
Given a non-empty array of integers nums, every element appears twice except for one.
Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra
space.
 */
public class Q136 {
    public int singleNumber(int[] nums){
        int a = 0;
        for (int i : nums){
            a ^= i;
        }
        return a;
    }

    public static void main(String[] args){
        int[] nums = {2, 2, 1};
        Q136 q = new Q136();
        System.out.println(q.singleNumber(nums));
    }
}
