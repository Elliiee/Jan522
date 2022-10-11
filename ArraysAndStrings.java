import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArraysAndStrings {
    // This part is from Explore card -- Array and String
/*
Introduction:
Array and Dynamic Array
 */


    /*
    724. find pivot index
    given an array of integers nums, calculate the pivot index of this array.
    The pivot index is the index where the sum of all the numbers strictly to the left of the index is
    equal to the sum of all the numbers strictly to the index's right. If the index is on the left edge
    of the array, then the left sum is 0 because there are no elements to the left. This also applies
    to the right edge of the array. Return the leftmost pivot index. If no such index exists, return -1.
     */
    // prefix sum technique
    public int pivotIndex(int[] nums){
        int sum = 0, leftSum = 0;

        for (int n : nums)
            sum += n;

        for (int i = 0; i < nums.length; i++){
            if (leftSum == sum - leftSum - nums[i])
                return i;

            leftSum += nums[i];
        }
        return -1;
    }


    /*
    747 largest number at least twice of others
    you are given an integer array nums where the largest integer is unique. Determine whether the largest element in
    the array is at least twice as much as every other number in the array. If it is, return the index of the largest
    element, or return -1 otherwise.
     */
    public int dominantIndex(int[] nums){
        int n = nums.length;
        int max = 0, maxIndex = -1;
        for (int i = 0; i < n; i++){
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        for (int j = 0; j < n; j++){
            if ((nums[j] != max) &&  (max < 2 * nums[j])){
                return -1;
            }
        }
        return maxIndex;
    }


    /*
    66 plus one
    you are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the
    integer. The digits are ordered from most significant to the least significant in left-to-right order. The large
    integer does not contain any leading 0's. Increment the large integer by one and return the resulting array of digits.
     */
    public int[] plusOne(int[] digits){
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] new_number = new int[n + 1];
        new_number[0] = 1;
        return new_number;
    }

    /*
    Introduction to 2D Array
     */
    

    /*
    498. Diagonal Traverse
    Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
     */
    public int[] findDiagonalOrder(int[][] mat){
        if (mat == null || mat.length == 0)
            return new int[0];

        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};

        for (int i = 0; i < m * n; i++){
            result[i] = mat[row][col];
            row +=dirs[d][0];
            col += dirs[d][1];

            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}
            if (col < 0)  { col = 0; d = 1 - d;}
        }
        return result;
    }

    /*
    54. Spiral Matrix
    Given an m x n matrix, return all elements of the matrix in spiral order.
     */

    /*
    118. Pascal's Triangle
    Given an integer numRows, return the first numRows of Pascal's triangle.
     */
    public List<List<Integer>> generate(int numRow){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int row = 1; row < numRow; row++){
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(row - 1);
            currRow.add(1); // first number is always 1

            for (int i = 1; i < row; i++){
                currRow.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            currRow.add(1); // last number is always 1
            triangle.add(currRow);
        }
        return triangle;
    }

    //Introduction to String

    /*
    67.Add Binary
    Given two binary strings a and b, return their sum as a binary string.
     */


    /*
    Implement strStr()
     */

    /*
    14. Longest Common Prefix
    Write a function to find the longest common prefix string among an array of strings.
    If there is no common prefix, return an empty string "".
     */
    public String longestCommonPrefix(String[] strs){
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    // Two pointer techniques


    /*
    344. Reverse String
     */
    public void reverseString(char[] s){
        int i = 0, j = s.length - 1;
        while (i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /*
    561. Array Partition
    Given an integer array nums of 2n integers, group these integers into n pairs such that the sum of
    min(a, b) for all i is maximized. Return the maximized sum.
     */
    public int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i += 2){
            max += nums[i];
        }
        return max;
    }

    /*
    Remove Element
     */


    /*
    Max Consecutive ones
     */


    /*
    209. Minimum Size Subarray Sum
     */

    /*
    189. Rotate Array
    Given an array, rotate the array to the right by k steps where k is non-negative.
     */
    public void rotate(int[] nums, int k){
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    /*
    119. Pascal's Triangle II
    Given an integer, rowIndex, return the rowIndex-th 0-index row of the Pascal's triangle.
     */
    public List<Integer> getRow(int rowIndex){
        List<Integer> result = new ArrayList<>();
        result.add(1); // first number is always 1
        for (int i = 1; i <= rowIndex; i++){
            for ( int j = i - 1; j >= 1; j--){
                int temp = result.get(j - 1) + result.get(j);
                result.set(j, temp);
            }
            result.add(1); // last number is always 1
        }
        return result;
    }

    /*
    151. Reverse words in a string
    Given an input string s, reverse the order of the words. A word is defined as a sequence of
    non-space characters. The word is s will be separated by at least one space. Return a string of
    the words in reverse order concatenated by a single space.
     */
    public String reverseWords(String s){
        String[] words = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--){
            if (!words[i].isEmpty())
                result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }


    /*
    Reverse words in a string III
    Given a string s, reverse the order of characters in each word within a sentence while still
    preserving whitespace and initial word order.
     */
    public String reverseWordsIII(String s){
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String w : words){
            result.append(new StringBuilder(w).reverse().toString() + " ");
        }
        //StringBuffer is threadsafe and synchronized whereas StringBuilder is not.

        return result.toString().trim();
    }


    /*
    Remove duplicates from sorted array
     */

    /*
    Move zeros
     */






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
