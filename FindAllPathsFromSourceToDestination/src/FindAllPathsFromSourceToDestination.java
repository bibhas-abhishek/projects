import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 26 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/FindAllPathsFromSourceToDestination
 */

public class FindAllPathsFromSourceToDestination {

    private static class Graph {

        private int v;
        private List<Integer>[] adjList;

        public Graph(int v) {
            this.v = v;
            initGraph();
        }

        private void initGraph() {
            adjList = new ArrayList[v];
            for (int i = 0; i < v; i++)
                adjList[i] = new ArrayList<>();
        }

        public void addEdge(int u, int v) {
            adjList[u].add(v);
        }

        public void getAllPaths(int s, int d) {
            boolean[] isVisited = new boolean[v];
            List<Integer> path = new ArrayList<>();
            path.add(s);
            getAllPaths(s, d, isVisited, path);
        }

        private void getAllPaths(Integer u, Integer v, boolean[] isVisited, List<Integer> path) {
            isVisited[u] = true;
            if (u.equals(v))
                System.out.println(path);

            for (Integer i : adjList[u]) {
                if (!isVisited[i]) {
                    path.add(i);
                    getAllPaths(i, v, isVisited, path);
                    path.remove(i);
                }
            }
            isVisited[u] = false;
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int s = 2;
        int d = 3;
        g.getAllPaths(s, d);
    }

}
