import java.util.*;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/TopologicalSort
 **/

public class TopologicalSort {

    private static class Graph {


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

    }

    public void topologicalSort(Graph g) {
        int V = g.v;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSort(i, stack, visited, g);
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    private void topologicalSort(int i, Stack<Integer> stack, boolean[] visited, Graph g) {
        visited[i] = true;
        List<Integer> next = g.adjList[i];
        for (int node : next) {
            if (!visited[node])
                topologicalSort(node, stack, visited, g);

        }
        stack.push(i);
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        new TopologicalSort().topologicalSort(g);
    }

}
