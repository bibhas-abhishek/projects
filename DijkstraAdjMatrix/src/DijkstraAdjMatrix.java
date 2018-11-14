import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Nov 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/DijkstraAdjMatrix
 */

public class DijkstraAdjMatrix {

    private int V;

    public DijkstraAdjMatrix(int v) {
        V = v;
    }

    /**
     * utility function to find vertex with min cost not in spanning tree set
     */
    private int minDistance(int[] cost, boolean[] sptSet) {
        int minIndex = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if (!sptSet[i] && cost[i] <= min) {
                min = cost[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void printSpanningTree(int[] cost) {
        for (int i = 0; i < cost.length; i++)
            System.out.println(i + " -> " + cost[i]);
    }

    public void solveDijkstra(int[][] graph, int src) {
        int[] cost = new int[V];
        boolean[] sptSet = new boolean[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i < V; i++) {
            int u = minDistance(cost, sptSet);
            sptSet[u] = true; // mark u as processed
            for (int v = 0; v < V; v++) { // update cost for adjacent vertices of u not in sptSet
                if (graph[u][v] != 0 && !sptSet[v] && cost[u] != Integer.MAX_VALUE &&
                        graph[u][v] + cost[u] < cost[v])
                    cost[v] = graph[u][v] + cost[u];
            }
        }
        printSpanningTree(cost);
    }

    public static void main(String[] args) {
        int graph[][] = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijkstraAdjMatrix dijkstraAdjMatrix = new DijkstraAdjMatrix(graph.length);
        dijkstraAdjMatrix.solveDijkstra(graph, 0);
    }

}
