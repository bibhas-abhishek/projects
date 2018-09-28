import java.util.HashSet;
import java.util.Set;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 01 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryTreePairSum
 **/

public class BinaryTreePairSum {

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
        if (!findIfSumExists(root, 11, new HashSet<>()))
            System.out.print("Pair not found");
    }

    private static boolean findIfSumExists(Node root, int key, Set<Integer> set) {
        if (root == null)
            return false;

        if (set.contains(key - root.data)) {
            System.out.print(String.valueOf(root.data) + " : " + String.valueOf(key - root.data));
            return true;
        } else
            set.add(root.data);

        return findIfSumExists(root.left, key, set) || findIfSumExists(root.right, key, set);
    }

}
