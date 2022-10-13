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
    public int findRotateIndex(int left, int right, int[] nums){
        if (nums[left] < nums[right])
            return 0;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                return mid + 1;
            } else {
                if (nums[mid] < nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return 0;
    }

    public int search(int left, int right, int[] nums, int target) {
    /*
    Binary search
    */
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    public int searchRotate(int[] nums, int target){
        int n = nums.length;
        if (n == 1)
            return nums[0] == target ? 0 : -1;

        int rotate_index = findRotateIndex(0, n - 1, nums);

        if (nums[rotate_index] == target)
            return rotate_index;

        if (rotate_index == 0)
            return search(0, n-1, nums, target);

        if (target < nums[0])
            return search(rotate_index, n - 1, nums, target);

        return search(0, rotate_index, nums, target );
    }


    /*
    Template II
    this is not a real template. in the following example, the target parameter is not exist at all.
     */
    public int templateII(int[] nums, int target){
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                left =  mid + 1;
            } else {
                right = mid;
            }
        }

        //post-processing end condition: left == right
        if (left != nums.length && nums[left] == target)
            return left;

        return -1;
    }

    /*
    Template 2 is an advanced form of binary search. It is used to search for an element or condition
    on which requires accessing the current index and its immediate right neighbor's index in the array.

    key attributes
    1. search condition needs to access the element's immediate right neighbor.
    2. use the element's right neighbor to determine if the condition is met and decide
    whether to go left or right.
    3.  Guarantees search space is at least 2 in size at each step
    4. post-processing required. when the loop/recursion ends you still have 1 elements left,
    need to assess if the remaining element meets the condition
     */

    // my observation: template II is for un-sorted array to find max or min element
    // the comparison is between 2 neighbor elements

    /*
    162. find peak element
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                right = mid; // descreasing
            } else {
                left = mid + 1;
                // increasing, mid + 1 is bigger than mid so set left to mid + 1
            }
        }
        return left;
    }

    /*
    153. find minimum in rotated sorted array
     */
    public int findMin(int[] nums){
        if (nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    /*
    template III
     */
    public int templateIII(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) { // so there are at least 3 elements in the comparison
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // Post-processing:
        // End Condition: left + 1 == right
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }

        //post-processing end condition: left + 1 = right


        /*
        Template 3 requires to access the current index and its immediate left and right neighbor's index.

        key
        1. search condition needs to access element's immediate left and right neighbors
        2. search space is at least 3 in size at each step
        3. post-processing required. loop/recursion ends when you have 2 elements left.
        need to assess if the remaining elements meet the condition
        Distinguishing Syntax:

        Initial Condition: left = 0, right = length-1
        Termination: left + 1 == right
        Searching Left: right = mid;
        Searching Right: left = mid
         */



    /*
    34. find the first and last positions of the element in the array
     */

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                idx = mid;
                /*
                because nothing after mid can be the first occurrence of target
                maybe mid is the first or maybe not, so let's narrow the target
                for [0, mid - 1] and find out
                 */
                right = mid - 1; // key step
            }
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                idx = mid;
                /*
                because nothing before mid can be the last occurrence of the target
                maybe mid is the last or maybe not, so let's narrow the target for [mid + 1, high] and find out
                 */
                right = mid + 1; // key step
            }
        }
        return idx;
    }

    public int[] searchRange(int[] nums, int target){
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
}
