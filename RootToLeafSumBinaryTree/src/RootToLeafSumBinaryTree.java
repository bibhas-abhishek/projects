import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 11 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RootToLeafSumBinaryTree
 **/

public class RootToLeafSumBinaryTree {

    private static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        List<Integer> path = new ArrayList<>();
        boolean result = rootToLeafSum(root, 17, path);
        if (!result)
            System.out.println("Path not found");
        else {
            for (int i : path)
                System.out.print(i + " ");
        }
    }

    private static boolean rootToLeafSum(Node root, int sum, List<Integer> path) {
        if (root == null)
            return false;

        int diff = sum - root.data;
        if (root.left == null && root.right == null) {
            if (diff == 0) {
                path.add(root.data);
                return true;
            } else
                return false;
        }

        if (rootToLeafSum(root.left, diff, path) || rootToLeafSum(root.right, diff, path)) {
            path.add(root.data);
            return true;
        }
        return false;
    }

}
