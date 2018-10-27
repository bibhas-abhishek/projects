import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 26 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/JobSequencing
 */

public class JobSequencing {

    private class DisjointSet {

        private Map<Integer, Node> map = new HashMap<>(); // data -> node

        private class Node {

            int data;
            Node parent;

        }

        public void makeSet(int data) {
            Node node = new Node();
            node.data = data;
            node.parent = node;
            map.put(data, node);
        }

        public Node findSet(int data) {
            return findSet(map.get(data));
        }

        public Node findSet(Node node) {
            Node parent = node.parent;
            if (parent == node)
                return parent;

            node.parent = findSet(node.parent);
            return node.parent;
        }

        public void union(int data1, int data2) {
            Node node1 = map.get(data1);
            Node node2 = map.get(data2);

            Node parent1 = findSet(node1);
            Node parent2 = findSet(node2);

            if (parent1 != parent2)
                parent2.parent = parent1;
        }

    }

    private static class Job {

        char id;
        int deadline;
        int profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

    }

    private int findMaxDeadline(Job[] jobs) {
        int result = Integer.MIN_VALUE;
        for (Job job : jobs)
            result = Math.max(result, job.deadline);

        return result;
    }

    public void jobSequencing(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        DisjointSet ds = new DisjointSet();
        int maxDeadline = findMaxDeadline(jobs);
        for (int i = 0; i <= maxDeadline; i++)
            ds.makeSet(i);

        for (Job job : jobs) {
            int availableSlot = ds.findSet(job.deadline).data;
            if (availableSlot > 0) {
                ds.union(ds.findSet(availableSlot - 1).data, availableSlot);
                System.out.print(job.id + " ");
            }

        }
    }

    public static void main(String[] args) {
        JobSequencing obj = new JobSequencing();
        Job[] jobs = {new Job('a', 2, 100), new Job('b', 1, 19),
                new Job('c', 2, 27), new Job('d', 1, 25), new Job('e', 3, 15)};
        obj.jobSequencing(jobs);
    }

}
