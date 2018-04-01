import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 01 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/TreeDiagonalTraversal
 **/

public class TreeDiagonalTraversal {

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
        printDiagonalTree(root);
    }

    private static void printDiagonalTree(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        map = diagonalMapUtil(root, 0, map);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            System.out.println(entry.getValue());
    }

    private static Map<Integer, List<Integer>> diagonalMapUtil(Node root, int hd, Map<Integer, List<Integer>> map) {
        if (root == null)
            return map;

        List<Integer> list = map.get(hd);
        if (list == null) {
            list = new ArrayList<>();
            list.add(root.data);
        } else
            list.add(root.data);
        map.put(hd, list);

        diagonalMapUtil(root.right, hd, map);
        diagonalMapUtil(root.left, hd - 1, map);
        return map;
    }

}
