import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 30 Jun 2018
 * https://www.hackerrank.com/challenges/components-in-graph/problem
 * https://github.com/bibhas-abhishek/projects/tree/master/DisjointSet
 *
 * Space complexity:  O(n)
 * Time complexity:  O(m * alpha * n)
 * m = operations, n = elements, alpha * n <= 4
 * => Time ~= O(m)
 **/

public class DisjointSet {

    private static Map<Long, Node> map = new HashMap<>(); // data -> node

    private static class Node {

        long data;
        Node parent;
        int rank; // -> size

    }

    // Create a set with only one element
    public static void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 1;
        map.put(data, node);
    }

    // Finds the representative of this set
    public static Node findSet(long data) {
        return findSet(map.get(data));
    }

    // Find the representative recursively and do path compression
    public static Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node)
            return parent;

        node.parent = findSet(node.parent); // path compression
        return node.parent;
    }

    public static boolean union(long data1, long data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if (parent1.data == parent2.data)
            return false; // already in the same set

        if (parent1.rank >= parent2.rank) {
            parent1.rank += parent2.rank;
            parent2.parent = parent1;
        } else {
            parent2.rank += parent1.rank;
            parent1.parent = parent2;
        }
        return true;
    }

    public static int[] componentsInGraph(int n, int[][] gb) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i <= 2 * n; i++)
            makeSet(i);

        for (int[] component : gb)
            union(component[0], component[1]);

        for (int i = 1; i <= 2 * n; i++) {
            int rank = findSet(i).rank;
            min = rank > 1 ? Math.min(min, rank) : min;
            max = Math.max(max, rank);
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        makeSet(1);
        makeSet(2);
        makeSet(3);
        makeSet(4);
        makeSet(5);
        makeSet(6);
        makeSet(7);

        union(1, 2);
        union(2, 3);
        union(4, 5);
        union(6, 7);
        union(5, 6);
        union(3, 7);

        System.out.println(findSet(1));
        System.out.println(findSet(2));
        System.out.println(findSet(3));
        System.out.println(findSet(4));
        System.out.println(findSet(5));
        System.out.println(findSet(6));
        System.out.println(findSet(7));

        /*int[][] gb = {{1, 6}, {2, 7}, {3, 8}, {4, 9}, {2, 6}};
        int[] result = componentsInGraph(5, gb);
        Arrays.stream(result).mapToObj(n -> n + " ").forEach(System.out::print);*/
    }

}
