import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 30 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/Graph
 */

public class Graph {


    private int v;
    private List<Integer>[] adjList;

    Graph(int v) {
        this.v = v;
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++)
            adjList[i] = new ArrayList<>();
    }

    private void addEdge(int u, int v) {
        adjList[u].add(v);
    }


    public void printGraph() {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("[" + i + "]");
            List<Integer> nodeList = adjList[i];
            for (Integer node : nodeList)
                System.out.print("->" + node);
            System.out.println();
        }
    }

    /**
     * O(V+E)
     * @param s
     */
    public void breadthFirstSearch(int s) {
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            System.out.print(node + " ");
            for (int neighbour : adjList[node]) {
                if (!visited[neighbour])
                    queue.add(neighbour);
            }
        }
    }

    /**
     * O(V+E)
     * @param s
     */
    public void depthFirstSearch(int s) {
        boolean[] visited = new boolean[adjList.length];
        depthFirstSearch(s, visited);
    }

    private void depthFirstSearch(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbour : adjList[node]) {
            if (!visited[neighbour])
                depthFirstSearch(neighbour, visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.printGraph();
        System.out.print("BFS: ");
        g.breadthFirstSearch(2);

        System.out.println();
        System.out.print("DFS: ");
        g.depthFirstSearch(2);
    }

}
