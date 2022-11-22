import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56 {
    /*
    56 Merge Intervals
    Given an array of intervals where intervals[i] = [start, end], merge all overlapping
    intervals, and return an array of the non-overlapping intervals that cover all the
    intervals in the input.

    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     */

    //This is like the Meeting Room problem?
    //Not the same, but they all sort the arrays by the start element

    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] - b[0]));

        ArrayDeque<int[]> result = new ArrayDeque<>();

        for (int[] interval : intervals){
            //If the list of merged intervals is empty or if the current interval
            //does not overlap with the previous, simply append it.
            if (result.isEmpty() || result.getLast()[1] < interval[0]){
                result.add(interval);
            } else {
                //there is overlap, so we merge the current and previous intervals
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }

        }

        return result.toArray(new int[result.size()][]); //notice this language writing
    }

    /*
    The idea is to sort the intervals by their starting points.
    Then, we take the first intervals and compare its end with the next interval's start.
    As long as they overlap, we update the end to be the max end of the overlapping
    intervals.
    Once we find a non-overlapping interval, we can add the previous "extended" interval
    to the answer list and repeat the previous process.

    Sorting takes O(nlog(n)) and merging the intervals takes O(n).
    So, the resulting algorithm takes O(nlog(n)).
     */

    public int[][] mergeII(int[][] intervals){
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));

        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);//Does this mean you can change the end later ??
        for (int[] interval : intervals){
            if (interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
