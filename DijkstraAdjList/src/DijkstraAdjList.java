import java.util.*;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 08 Nov 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/DijkstraAdjList
 */

public class DijkstraAdjList {

    private static class Edge {

        private int src;
        private int dest;
        private int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

    }

    private static class Node {

        private int index;
        private int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

    }

    private int V;
    private LinkedList<Edge>[] adjList;

    public DijkstraAdjList(int v) {
        this.V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adjList[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        adjList[src].addFirst(new Edge(src, dest, weight));
        adjList[dest].addFirst(new Edge(dest, src, weight));
    }

    public void printSpanningTree(Node[] heapNodes) {
        for (Node node : heapNodes)
            System.out.println(node.index + " -> " + node.dist);
    }

    public void solveDijkstra(int src) {
        boolean[] sptSet = new boolean[V];
        Node[] heapNodes = new Node[V];
        Queue<Node> minheap = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for (int i = 0; i < V; i++) {
            heapNodes[i] = new Node(i, i == src ? 0 : Integer.MAX_VALUE);
            minheap.offer(heapNodes[i]);
        }

        while (!minheap.isEmpty()) {
            Node u = minheap.poll();
            int uIndex = u.index; // popped vertex
            sptSet[uIndex] = true; // process vertex as part of spanning tree
            for (Edge edge : adjList[uIndex]) {
                int uDest = edge.dest; // destination index
                if (!sptSet[uDest]) { // if destination index not already in spanning tree
                    int newDist = heapNodes[uIndex].dist + edge.weight; // new cost of dest vertex
                    int curDist = heapNodes[uDest].dist; // current cost of dest vertex
                    if (curDist > newDist) {
                        minheap.remove(heapNodes[uDest]); // pop dest node from minHeap
                        heapNodes[uDest].dist = newDist; // update dest vertex cost
                        minheap.offer(heapNodes[uDest]); // add updated vertex to minHeap
                    }
                }
            }
        }
        printSpanningTree(heapNodes);
    }

    public static void main(String[] args) {
        DijkstraAdjList graph = new DijkstraAdjList(9);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);
        graph.solveDijkstra(0);
    }

}
