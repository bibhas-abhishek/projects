import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Nov 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/LargestIndependentSet
 */

public class LargestIndependentSet {

    private static class Node {

        private int val;
        private Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }

    }

    public int largestIndependentSet(Node root) {
        return largestIndependentSet(root, new HashMap<>());
    }

    private int largestIndependentSet(Node root, Map<Node, Integer> memo) {
        if (root == null)
            return 0;

        if (memo.get(root) != null)
            return memo.get(root);

        if (root.left == null && root.right == null) {
            memo.put(root, 1);
            return 1;
        }

        int lisExcl = largestIndependentSet(root.left, memo) +
                largestIndependentSet(root.right, memo);

        int lisIncl = 1;
        if (root.left != null)
            lisIncl += largestIndependentSet(root.left.left, memo) +
                    largestIndependentSet(root.left.right, memo);

        if (root.right != null)
            lisIncl += largestIndependentSet(root.right.left, memo) +
                    largestIndependentSet(root.right.right, memo);

        int result = Math.max(lisExcl, lisIncl);
        memo.put(root, result);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        System.out.println(new LargestIndependentSet().largestIndependentSet(root));
    }

}
