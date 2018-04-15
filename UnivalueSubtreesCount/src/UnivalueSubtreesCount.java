/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 15 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/UnivalueSubtreesCount
 **/

public class UnivalueSubtreesCount {

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    private static int count;

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        getUnivalueSubtreeCount(root, Integer.MIN_VALUE);
        System.out.println(count);
    }

    private static int getUnivalueSubtreeCount(Node root, int value) {
        if (root == null)
            return value;
        int leftData = getUnivalueSubtreeCount(root.left, root.data);
        int rightData = getUnivalueSubtreeCount(root.right, root.data);
        if (leftData == rightData && leftData == root.data) {
            count += 1;
            return root.data;
        } else
            return Integer.MIN_VALUE;
    }

}
