import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Jun 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/GraphOperations
 **/

public class GraphOperations {

    private static class Graph {

        List<LinkedList<Integer>> adjList;

        Graph(int v) {
            this.adjList = new ArrayList<>(v);
            for (int i = 0; i < v; i++)
                adjList.add(new LinkedList<>());
        }

        private void addEdge(int src, int dest) {
            adjList.get(src).add(dest);
        }

    }

    static Graph buildGraph(int[] nodes, int[][] graphNodes, boolean isDirected) {
        Graph graph = new Graph(nodes.length);
        for (int[] graphNode : graphNodes) {
            graph.addEdge(graphNode[0], graphNode[1]);
            if (!isDirected)
                graph.addEdge(graphNode[1], graphNode[0]);
        }
        return graph;
    }

    static void printGraph(Graph graph) {
        for (int i = 0; i < graph.adjList.size(); i++) {
            System.out.print("[" + i + "]");
            List<Integer> nodeList = graph.adjList.get(i);
            for (Integer node : nodeList)
                System.out.print("->" + node);
            System.out.println();
        }
    }

    static void breadthFirstSearch(Graph graph, int u) {
        boolean[] visited = new boolean[graph.adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            u = queue.poll();
            System.out.print(u + " ");
            List<Integer> nodeList = graph.adjList.get(u);
            for (Integer node : nodeList) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }

    static void depthFirstSearch(Graph graph, int u) {
        boolean[] visited = new boolean[graph.adjList.size()];
        depthFirstSearch(graph, u, visited);
    }

    private static void depthFirstSearch(Graph graph, int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        List<Integer> nodeList = graph.adjList.get(u);
        for (Integer node : nodeList) {
            if (!visited[node])
                depthFirstSearch(graph, node, visited);
        }
    }

    public static void main(String[] args) {
        int[][] graphNodes = {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}, {3, 1}, {3, 3}};
        int[] nodes = {0, 1, 2, 3};
        Graph graph = buildGraph(nodes, graphNodes, true);
        printGraph(graph);
        System.out.println();
        breadthFirstSearch(graph, 3);
        System.out.println();
        depthFirstSearch(graph, 0);
    }

}
