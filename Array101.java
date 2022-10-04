import java.util.*;

public class Array101 {
    /*
    485, max consecutive ones
    Given a binary array nums, return the maximum number of consecutive 1's in the array.
     */
    public int findMaxConsecutiveOnes(int[] nums){
        int count = 0, maxCount = 0;
        for (int i = 0; i < nums.length; i++){
            count += nums[i];
            if (nums[i] == 0)
                count = 0;
            else
                maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    /*
    1295. find numbers with even number of digits
    Given an array nums of integers, return how many of them contain an even number of digits.
    Constraints:
    1 <= nums[i] <= 10power5
     */
    public int findNumbers(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if ((nums[i] > 9 && nums[i] < 100) || (nums[i] > 999 && nums[i] < 1000) || nums[i] == 100000)
                count++;
        }
        return count;
    }


    /*
    977. squares of a sorted array
    given an integer array nums sorted in non-decreasing order, return an array of
    the squares of each number sorted in non-decreasing order.
    (It has negative numbers to be noted.)
     */
    // two pointers
    public int[] sortedSquares(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = n - 1;

        //Two pointers
        for (int i = n - 1; i >= 0; i--){
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])){
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            ans[i] = square * square;
        }
        return ans;
    }

    /*
    1089 duplicated zeros
    given a fixed-length integer array arr, duplicate each occurrence of zero, shifting
    the remaining elements to the right. Note that elements beyond the length of the
    original array are not written. Do the above modifications to the input array in place
    and do not return anything.
     */
    public void duplicateZeros(int[] arr){
        int possibleDups = 0;
        int right = arr.length - 1;

        for (int left = 0; left <= right - possibleDups; left++){
            if (arr[left] == 0){
                if (left == right - possibleDups){
                    arr[right] = 0;
                    right--;
                    break;
                }
                possibleDups++;
            }
        }

        int last = right - possibleDups;

        for (int i = last; i >= 0; i--){
            if (arr[i] == 0){
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }

    /*
    27 remove element
    given an integer array nums and an integer val, remove all occurrences of val
    in nums in-place. The relative order of the elements may be changed. Since it
    is impossible to change the length of the array in some language, you must
    instead have the result be placed in the first part of the array nums. DO
    not use extra space for another array.
    Return k after placing the final result in the first k slots of nums.
     */
    // two pointers
    public int removeElement(int[] nums, int val){
        int slow = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val)
                nums[slow++] = nums[i];
        }
        return slow;
    }

    /*26
    Given an integer array nums sorted in non-decreasing order, remove the
    duplicates in-place such that each unique element appears only once. The
    relative order of the elements should be kept the same. Do not allocate
    extra space for another array. You must do this by modifying the input
    array in-place with O(1) extra money.
    Return k after placing the final result in the first k slots of nums.
     */
    // two pointers
    public int removeDuplicates(int[] nums){
        int slow = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] != nums[i])
                nums[slow++] = nums[i];
        }
        return slow;
    }

    /*
    1346. check if N and its double exist
    Given an array arr of integers, check if there exists two indicies i and j
    such that i != j, 0 <= i, j < arr.length, arr[i] == 2 * arr[j]
     */
    public boolean checkIfExist(int[] arr){
        Set<Integer> seen = new HashSet<>();
        for (int i : arr){
            if (seen.contains(2 * i) || i % 2 == 0 && seen.contains(i / 2))
                return true;
            seen.add(i);
        }
        return false;
    }

    /*
    941 valid mountain array
    Given an array of integers arr, return true if and only if it is a valid
    mountain array.
     */
    public boolean validMountainArray(int[] arr){
        int i = 0, n = arr.length;

        while ((i + 1) < n && arr[i] < arr[i + 1]){
            i++;
        }

        // peak can't be the first or last element
        if (i == 0 || i == n - 1)
            return false;

        while ((i + 1) < n && arr[i] > arr[i + 1]){
            i++;
        }

        return i == n - 1;
    }

    /*
    1299 replace elements with the greatest element on right side
    given an array arr, replace every element in that array with the greatest
    element among the elements to its right, and replace the last element with
    -1. Return the array.
     */
    public int[] replaceElements(int[] arr){
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--){
            int temp = max;
            if (arr[i] > max)
                max = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /*
    283 move zeros
    Given an integer array nums, move all 0's to the end of it while maintaining
    the relative order of the non-zero elements. Note that you must do this in
    place without making a copy of the array.
     */

    public void moveZeros(int[] nums){
        int slow = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0)
                nums[slow++] = nums[i];
        }

        for (int i = slow; i < nums.length; i++){
            nums[slow++] = 0;
        }
    }

    /*
    905 sort array by parity
    given an integer array nums, move all the even integers at the beginning of
    the array followed by all the odd integers. Return any array that satisfies
    this condition.
     */
    public int[] sortArrayByParity(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            if (nums[left] % 2 > nums[right] % 2){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if (nums[left] % 2 == 0)
                left++;
            if (nums[right] % 2 == 1)
                right--;
        }
        return nums;
    }

    /*
    1051 Height Checker
    A school is trying to take an annual photo of all the students. The students are asked to stand
    in a single file line in non-decreasing order by height. Let this ordering be represented by the
    integer array expected where expected[i] is the expected height of the ith student in line.
    You are given an integer array heights representing the current order that the students are
    standing in. Each heights[i] is the height of the ith student in line 0 indexed. Return the number
    of indexes where heights[i] != expected[i].
     */
    public int heightChecker(int[] heights){
        int count = 0;
        int n = heights.length;
        int[] copyOfHeights = new int[n];

        for (int i = 0; i < n; i++){
            copyOfHeights[i] = heights[i];
        }

        Arrays.sort(heights);

        for (int i = 0; i < n; i++){
            if (heights[i] != copyOfHeights[i])
                count++;
        }

        return count;
    }



    /*
    487 Max consecutive ones II
    Given a binary array nums, return the max number of consecutive 1's in the
    array if you can flip at most one 0.
     */
    // sliding window



    /*
    414 Third max number
    Given an integer array nums, return the third distinct maximum number in this
    array. If the third max does not exist, return the max number.
     */
    public int thirdMax(int[] nums){
        Integer max1 = null, max2 = null, max3 = null;

        for (Integer n : nums){
            if (n.equals(max1) || n.equals(max2) || n.equals(max3))
                continue;

            if (max1 == null || n > max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2){
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3){
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    /*
    448 find all numbers disappeared in array
    Given an array nums of n integers where num[i] is in the range [1, n], return
    an array of all the integers in the range that do not appear in nums.
     */
    public List<Integer> findDisappearedNumber(int[] nums){
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);

        for (int i = 1; i <= nums.length; i++){
            if (!set.contains(i))
                answer.add(i);
        }
        return answer;
    }


}
