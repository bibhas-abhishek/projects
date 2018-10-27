import java.util.*;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 27 Oct 2018
 * https://leetcode.com/problems/task-scheduler/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/TaskScheduler
 */

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0)
            return -1;

        Map<Character, Integer> taskCount = new HashMap<>();
        int result = 0;
        for (char ch : tasks)
            taskCount.put(ch, taskCount.getOrDefault(ch, 0) + 1);

        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(taskCount.entrySet());
        while (!queue.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> t = new ArrayList<>();
            while (!queue.isEmpty() && k > 0) {
                Map.Entry<Character, Integer> e = queue.poll();
                e.setValue(e.getValue() - 1);
                t.add(e);
                k -= 1;
                result += 1;
            }

            for (Map.Entry<Character, Integer> e : t) {
                if (e.getValue() > 0)
                    queue.offer(e);
            }

            if (queue.isEmpty())
                break;

            result += k;
        }
        return result;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));
    }

}
