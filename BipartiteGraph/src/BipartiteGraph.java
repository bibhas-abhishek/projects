import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BipartiteGraph
 */

public class BipartiteGraph {

    private class DisjointSet {

        private Map<Long, Node> map = new HashMap<>();

        private class Node {

            long data;
            Node parent;
            int rank;

        }

        public void makeSet(long data) {
            Node node = new Node();
            node.data = data;
            node.parent = node;
            node.rank = 1;
            map.put(data, node);
        }

        public Node findSet(long data) {
            return findSet(map.get(data));
        }

        public Node findSet(Node node) {
            Node parent = node.parent;
            if (parent == node)
                return parent;

            node.parent = findSet(node.parent);
            return node.parent;
        }

        public boolean union(long data1, long data2) {
            Node node1 = map.get(data1);
            Node node2 = map.get(data2);

            Node parent1 = findSet(node1);
            Node parent2 = findSet(node2);

            if (parent1.data == parent2.data)
                return false;

            if (parent1.rank >= parent2.rank) {
                parent1.rank += parent2.rank;
                parent2.parent = parent1;
            } else {
                parent2.rank += parent1.rank;
                parent1.parent = parent2;
            }
            return true;
        }

    }

    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !validColor(graph, colors, 1, i))
                return false;
        }
        return true;
    }

    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0)
            return colors[node] == color;

        colors[node] = color;
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next))
                return false;
        }
        return true;
    }

    public boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        int colors[] = new int[n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if (colors[i] == 0) {
                colors[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int next : graph[node]) {
                        if (colors[next] == 0) {
                            colors[next] = -colors[node];
                            queue.offer(next);
                        } else {
                            if (colors[next] == colors[node])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    public boolean isBipartiteDisjointSet(int[][] graph) {
        DisjointSet ds = new DisjointSet();
        int n = graph.length;
        for (int i = 0; i < n; i++)
            ds.makeSet(i);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (ds.findSet(i) == ds.findSet(graph[i][j]))
                    return false;

                if (j > 0)
                    ds.union(graph[i][j], graph[i][j - 1]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph obj = new BipartiteGraph();
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}};
        System.out.println(obj.isBipartiteDisjointSet(graph));
    }

}
