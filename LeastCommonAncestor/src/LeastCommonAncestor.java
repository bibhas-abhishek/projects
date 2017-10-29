/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 29 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/LeastCommonAncestor
 */
public class LeastCommonAncestor {

    private static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        Node result = LCAUtil(root, 2, 12);
        System.out.println(result != null ? result.data : "No LCA");
    }

    private static Node LCAUtil(Node root, int v1, int v2) {
        if (!covers(root, v1) || !covers(root, v2))
            return null;
        if (root == null || root.data == v1 || root.data == v2)
            return root;
        boolean isV1Left = covers(root.left, v1);
        boolean isV2left = covers(root.left, v2);
        if (isV1Left ^ isV2left)
            return root;
        else {
            return isV1Left ? LCAUtil(root.left, v1, v2) : LCAUtil(root.right, v1, v2);
        }
    }

    private static boolean covers(Node root, int data) {
        if (root == null) return false;
        if (root.data == data) return true;
        return covers(root.left, data) || covers(root.right, data);
    }

}
