public class ExploreLearnCardBinarySearch {
    /*
    How does it work.
    If the search ends with an empty half, the condition cannot be fulled and the target is not found.
     */

    /*
    704. Binary Search
     */
    public int search(int[] nums, int target){
        int mid, left = 0, right = nums.length - 1;
        while (left <= right){
            mid = left + (right - left)/2 ;
            if (nums[mid] == target){
                return mid;
            }
            if (target < nums[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    /*
    How do we identify binary search?
    If the collection is unordered, we can always sort it first before applying binary search.
    You should consider binary search everytime you in-counter a search problem.

    3 parts of a successful binary search
    1. pre-processing: sort if collection is unsorted
    2. binary search: divide search space in half after each comparison.
    3. post-processing: determine viable candidates in the remaining space.

    Here are 3 templates for binary search.
    But each problem is different. You might need to change the template accordingly.
     */

    // template I
    public int templateI(int[] nums, int target){
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2; // prevent (left + right) overflow
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // end condition: left > right
    }
    /*
    Template 1 is the most basic and elementary for of binary search.
        It is used to search for an element or condition which can be determined by
     accessing a single index in the array.

     search condition can be determined without comparing to the element's neighbors.

     no post-processing required because at each step, you are checking to see if the
     element has been found. If you reach the end, you know the element is not found.

     Distinguish Syntax
     initial condition: left = 0, right = length - 1;
     termination: left > right
     searching left: right = mid - 1;
     searching right: left = mid + 1;
     */

    /*
    69. sqrt(x)
    given a non-negative integer x, compute and return the square root of x.
     */
    public int mySqrt(int x){
        if (x < 2)
            return x;
        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right){
            pivot = left + (right - left)/2;
            num = (long) pivot * pivot;

            if (num > x){
                right = pivot - 1;
            } else if (num < x){
                left = pivot + 1;
            } else {
                return pivot;
            }
        }
        return right;
    }

    /*
    33. search in rotated sorted array
     */
}
