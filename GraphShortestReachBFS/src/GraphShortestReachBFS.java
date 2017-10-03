import java.util.*;

public class GraphShortestReachBFS {

    private static class Graph {

        private Map<Integer, Set<Integer>> graph;
        private boolean[] visited;
        private final int EDGE_WEIGHT = 6;

        public Graph(int nodeCount) {
            graph = new HashMap<>();
            visited = new boolean[nodeCount];
            Arrays.fill(visited, false);
            for (int i = 1; i <= nodeCount; i++)
                graph.put(i, new HashSet<>());
        }

        public Map<Integer, Set<Integer>> getGraph() {
            return graph;
        }

        public boolean[] getVisited() {
            return visited;
        }

        public int getEdgeWeight() {
            return EDGE_WEIGHT;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph graph = null;
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int nodeCount = in.nextInt();
            int edgeCount = in.nextInt();

            graph = new Graph(nodeCount);
            for (int j = 0; j < edgeCount; j++) {
                int u = in.nextInt();
                int v = in.nextInt();

                graph.getGraph().get(u).add(v);
                graph.getGraph().get(v).add(u);
            }

            int start = in.nextInt();
            shortestReach(graph, nodeCount, start);
            System.out.println();
        }
    }

    private static void shortestReach(Graph graph, int nodeCount, int start) {
        int[] distance = new int[nodeCount];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start - 1] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            Set<Integer> adjacencyList = graph.getGraph().get(u);
            for (int v : adjacencyList) {
                if (!graph.getVisited()[v - 1]) {
                    graph.getVisited()[v - 1] = true;
                    queue.add(v);
                    distance[v - 1] = distance[u - 1] + graph.getEdgeWeight();
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (i != start - 1)
                System.out.print(distance[i] + " ");
        }
    }

}
