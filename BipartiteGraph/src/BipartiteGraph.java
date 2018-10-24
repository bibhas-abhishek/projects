import java.util.LinkedList;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BipartiteGraph
 */

public class BipartiteGraph {

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
                            if (colors[node] == colors[next])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
