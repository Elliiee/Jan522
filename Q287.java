import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q287 {
    /*
    287. Find the Duplicate Number
    Given an array of integers nums containing n + 1 integers where each integer is in the
    range [1, n] inclusive.
    There is only one repeated number in nums, return this repeated number.
    You must solve the problem without modifying the array nums and uses only constant
    extra space.
    It can be repeated n times. multiple times
     */

    //This problem is very hard to understand for me.

    //12/06/22
    //The hard part of this question is modifying in-place. And you can't use
    // extra space.

    /*
    Finding the duplicate number is a classic problem, and as such there are many
    ways to approach it;
    A total of 7 approaches are presented here.
    The first 4 approaches do not meet the requirement. It changes the elements
    places.
     */

    /*
    Pigeonhole principle:
    There are n pigeonholes and n + 1 pigeons.
    So there must be one pigeonholes with 2 pigeons.
     */

    /*
    Approach 1 sort
    This does not meet the requirement. Because it changes the original sequence.
    Intuition:
    In an unsorted array, duplicate elements may be scattered across the array.
    However, in a sorted array, duplicate number will be next to each other.
    Time Complexity: O(nlog⁡n)O(n \log n)O(nlogn)
     */
    public int findDuplicate(int[] nums){
        Arrays.sort(nums); //not in-place
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1])
                return nums[i];
        }
        return -1;
    }

    /*
    Approach 2 Set
    This does not meet requirement of not using extra space.
     */
    public int findDuplicateII(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int n : nums){
            if (set.contains(n))
                return n;

            set.add(n);
        }
        return -1;
    }

    /*
    Approach 3 Negative Marking
    This changes the value of the elements. Not meet the requirement.
    Change the positive number to be negative because the question says all the
    numbers should be positive.
    So if you meet the positive one then you have found the duplicates.
     */
    public int findDuplicateIII(int[] nums){
        int duplicate = -1;

        for (int i = 0; i < nums.length; i++){
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0){
                duplicate = cur;
                break;
            }
            nums[cur] *= -1; //这里不用i ?????不明白
        }

        for (int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }

        return duplicate;
    }
    //这个方法说实话不是很明白

    /*
    Approach 4.1 Array as HashMap (Recursion)
    Intuition:
    Use the Array as a HashMap -- Map each number to its equivalent index.
    For instance, map and store the number 5 to index 5, nums[5] = 5. Since
    there are n + 1 positive numbers in the array. At least 1 index will have
    more than 2 numbers. Pigeonhole principle.
    Since numbers are ranging from 1 to n. The number at index 0 must be out of
    place, because it is not equal to 0 for sure.
    So let's assign firstNumber = nums[0], and then we want to make
    nums[firstNumber] = firstNumber !
    If nums[firstNumber] is already equals firstNumber before the assignment, then
    you have found the duplicates, nums[0] and numst[firstNumber] both equals
    firstNumber !!
    Otherwise, you swap them:
    int temp = nums[firstNumber];
    nums[firstNumber] = nums[0];
    nums[0] = temp;
    Then, you get a different new number at nums[0].
    Repeat the previous process until you find the duplicates.
     */
    public int store(int[] nums, int cur){
        if (cur == nums[cur])
            return cur; // find the duplicates

        //swap
        int temp = nums[cur];
        nums[cur] = cur;

        return store(nums, temp);
    }

    public int findDuplicateRecursion(int[] nums){
        return store(nums, 0);
    }
    //这很抽象，好难懂

    public int findDuplicateIterative(int[] nums){
        while (nums[0] != nums[nums[0]]){
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }
        return nums[0];
    }
    //这个看起来直接多了

    public int findDuplicateIterativeAgain(int[] nums){

        for(int i = 0; i < nums.length; i++){
            int first = nums[0];

            if(first == nums[first]){
                return first;
            }

            int temp = nums[first];
            nums[first] = nums[0];
            nums[0] = temp;
        }
        return -1;
    }//这个我自己写的，和题解是一样的思路了
    //不知道为什么这些题解说的和写的思路不完全一样，还是得靠自己理解。


    /*
    Approach 5 Binary Search
    这些题用到二分法也是无语，根本就不是典型的二分搜索的条件
    二分搜索的最显著条件就是已经排列好的队列才能用
    反正就这样吧

     */
}
