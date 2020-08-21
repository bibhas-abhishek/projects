import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    private static class UndirectedGraphNode {

        int                       label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    private Map<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        if (hashMap.containsKey(node)) {
            return hashMap.get(node);
        }

        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        hashMap.put(node, copy);
        for (UndirectedGraphNode n : node.neighbors) {
            copy.neighbors.add(cloneGraph(n));
        }
        return copy;
    }
}
