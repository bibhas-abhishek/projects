/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/CheckIfBST
 */
public class CheckIfBST {

    private class Node {
        int data;
        Node left;
        Node right;
    }

    public static void main(String[] args) {
        Node root = null;
        checkBST(root);
    }

    private static boolean checkBST(Node root) {
        return checkBST(root, null, null);
    }

    private static boolean checkBST(Node node, Integer min, Integer max) {
        if (node == null)
            return true;

        if ((min != null && node.data <= min) || (max != null && node.data >= max))
            return false;

        if (!checkBST(node.left, null, node.data) || !checkBST(node.right, node.data, null))
            return false;

        return true;
    }

}
