import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Mar 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/VerticalOrderTraversalBinaryTree
 **/

public class VerticalOrderTraversalBinaryTree {

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        printVerticalOrder(root);
    }

    private static void printVerticalOrder(Node root) {
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        printVerticalOrder(root, treeMap, 0);
        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet())
            System.out.println(entry.getValue());
    }

    private static void printVerticalOrder(Node root, Map<Integer, List<Integer>> treeMap, int hd) {
        if (root == null)
            return;

        List<Integer> keys = treeMap.get(hd);
        if (keys == null) {
            keys = new ArrayList<>();
            keys.add(root.data);
        } else
            keys.add(root.data);

        treeMap.put(hd, keys);
        printVerticalOrder(root.left, treeMap, hd - 1);
        printVerticalOrder(root.right, treeMap, hd + 1);
    }

}
