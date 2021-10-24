import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }

            pq.add(intervals[i][1]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        MeetingRooms2 driver = new MeetingRooms2();
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(driver.minMeetingRooms(intervals));
    }
}
