import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*https://www.geeksforgeeks.org/detect-cycle-in-a-graph*/

public class DetectCycleDirectedGraph {

    private static class Graph {

        private final int                 v;
        private final List<List<Integer>> adj;

        public Graph(int v) {
            this.v = v;
            adj = new ArrayList<>(v);
            for (int i = 0; i < v; i++)
                adj.add(new LinkedList<>());
        }

        public void addEdge(int source, int dest) {
            adj.get(source).add(dest);
        }
    }

    public boolean isCyclic(Graph g) {
        int V = g.v;
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, g, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int i, Graph g, boolean[] visited, boolean[] recStack) {
        if (recStack[i]) {
            return true;
        }

        if (!visited[i]) {
            visited[i] = true;
            recStack[i] = true;
            for (int c : g.adj.get(i)) {
                if (isCyclicUtil(c, g, visited, recStack)) {
                    return true;
                }
            }
            recStack[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println(new DetectCycleDirectedGraph().isCyclic(graph));
    }
}
