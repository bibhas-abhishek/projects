import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Nov 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/KruskalMST
 */

public class KruskalMST {

    private class Edge {

        private int src;
        private int dest;
        private int weight;

    }

    private class DisjointSet {

        private Map<Long, Node> map = new HashMap<>();

        private class Node {

            private long data;
            private Node parent;
            private int rank;

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

    private int V, E;
    private Edge[] edges;

    public KruskalMST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < E; i++)
            edges[i] = new Edge();
    }

    public void solveKruskalMST() {
        Edge[] result = new Edge[V];
        for (int i = 0; i < V; i++)
            result[i] = new Edge();

        Arrays.sort(edges, (a, b) -> a.weight - b.weight);
        DisjointSet ds = new DisjointSet();
        for (int i = 0; i < V; i++)
            ds.makeSet(i);

        int e = 0, k = 0;
        while (e < V - 1) {
            Edge nextEdge = edges[k++];
            DisjointSet.Node p = ds.findSet(nextEdge.src);
            DisjointSet.Node q = ds.findSet(nextEdge.dest);
            if (p != q) {
                result[e++] = nextEdge;
                ds.union(p.data, q.data);
            }
        }

        for (int i = 0; i < e; i++)
            System.out.println(result[i].src + " -> " + result[i].dest + " = " + result[i].weight);
    }

    /**
     * O(ElogE)
     */
    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        KruskalMST graph = new KruskalMST(V, E);

        // add edge 0->1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        // add edge 0->2
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        // add edge 0->3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        // add edge 1->3
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        // add edge 2->3
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;
        graph.solveKruskalMST();
    }

}
