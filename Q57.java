import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q57 {
    /*
    You are given an array of non-overlapping intervals intervals
    where intervals[i] = [starti, endi] represent the start and the end of
    the ith interval and intervals is sorted in ascending order by starti.
    You are also given an interval newInterval = [start, end] that
    represents the start and end of another interval.

    Insert newInterval into intervals such that intervals is still sorted
    in ascending order by starti and intervals still does not have any overlapping
    intervals (merge overlapping intervals if necessary).

    Return intervals after the insertion.
    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]
     */

    /*
    Note this question is already sorted by the start array!
     */

    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> result = new ArrayList<>();
        int i = 0;

        //add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        //merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        //add the inserted newInterval to the result
        result.add(newInterval);

        // add all the rest of intervals
        while (i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
