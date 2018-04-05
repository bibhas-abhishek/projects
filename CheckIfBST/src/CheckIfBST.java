/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/CheckIfBST
 */
public class CheckIfBST {

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
        System.out.println(checkBST(root));
        inorderDFS(root);
        System.out.println();
        System.out.println(isBSTAlt(root));
    }

    private static Node prev = null;

    private static boolean checkBST(Node root) {
        return checkBST(root, null, null);
    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private static boolean checkBST(Node node, Integer min, Integer max) {
        if (node == null)
            return true;

        if ((min != null && node.data < min) || (max != null && node.data >= max))
            return false;

        if (!checkBST(node.left, min, node.data) || !checkBST(node.right, node.data, max))
            return false;

        return true;
    }

    private static boolean isBSTAlt(Node root) {
        if (root == null)
            return true;

        if (!isBSTAlt(root.left))
            return false;

        if (prev != null && root.data < prev.data)
            return false;

        prev = root;
        if (!isBSTAlt(root.right))
            return false;

        return true;
    }

}
