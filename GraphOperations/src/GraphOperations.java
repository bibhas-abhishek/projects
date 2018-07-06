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

    static Graph buildGraph(int[] nodes, int[][] graphNodes) {
        Graph graph = new Graph(nodes.length);
        for (int[] graphNode : graphNodes)
            graph.addEdge(graphNode[0], graphNode[1]);
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

    static void breadthFirstSearch(Graph graph, int v) {
        boolean[] visited = new boolean[graph.adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");
            List<Integer> children = graph.adjList.get(v);
            for (Integer child : children) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
    }

    static void depthFirstSearch(Graph graph, int v) {
        boolean[] visited = new boolean[graph.adjList.size()];
        depthFirstSearch(graph, v, visited);
    }

    private static void depthFirstSearch(Graph graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        List<Integer> children = graph.adjList.get(v);
        for (Integer child : children) {
            if (!visited[child])
                depthFirstSearch(graph, child, visited);
        }
    }

    private static boolean isCyclicUndirected(Graph graph) {
        boolean[] visited = new boolean[graph.adjList.size()];
        for (int v = 0; v < graph.adjList.size(); v++) {
            if (!visited[v])
                if (isCyclicUndirected(graph, v, -1, visited)) // v-> current, u-> parent
                    return true;
        }
        return false;
    }

    private static boolean isCyclicUndirected(Graph graph, int v, int u, boolean[] visited) {
        visited[v] = true;
        List<Integer> children = graph.adjList.get(v);
        for (Integer child : children) {
            if (!visited[child]) {
                if (isCyclicUndirected(graph, child, v, visited))
                    return true;
            } else if (child != u) // if the child is the parent && visited -> not a cycle; any visited child
                return true;       // that is not the parent means a cycle
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graphNodes = {{0, 1}, {1, 2}, {2, 3}};
        int[] nodes = {0, 1, 2, 3};
        Graph graph = buildGraph(nodes, graphNodes);
        printGraph(graph);
        System.out.print("BFS: ");
        breadthFirstSearch(graph, 0);
        System.out.println();
        System.out.print("DFS: ");
        depthFirstSearch(graph, 0);
        System.out.println();
        System.out.println("isCyclic: " + isCyclicUndirected(graph));
    }

}
