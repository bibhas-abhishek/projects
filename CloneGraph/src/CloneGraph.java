import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 24 Apr 2018
 * https://leetcode.com/problems/clone-graph/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/CloneGraph
 **/

public class CloneGraph {

    static class UndirectedGraphNode {

        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }

    }

    private static Map<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<>();

    private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        if (hashMap.containsKey(node))
            return hashMap.get(node);

        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        hashMap.put(node, copy);
        for (UndirectedGraphNode n : node.neighbors)
            copy.neighbors.add(cloneGraph(n));

        return copy;
    }

}
