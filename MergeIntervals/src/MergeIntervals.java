import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 08 Jun 2018
 * https://leetcode.com/problems/merge-intervals/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MergeIntervals
 **/

public class MergeIntervals {

    private static class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }

    }

    private static List<Interval> merge(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start)     // no overlap
                merged.add(interval);
            else
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);        // overlap
        }
        return merged;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        System.out.println(merge(intervals));
    }

}
