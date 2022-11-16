import java.util.ArrayDeque;
import java.util.Arrays;

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
}
