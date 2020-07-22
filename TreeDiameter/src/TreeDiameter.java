/*https://leetcode.com/problems/diameter-of-binary-tree/description/*/

public class TreeDiameter {

    private static class Node {

        int  data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void inorderDFS(Node root) {
        if (root == null) {
            return;
        }
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepthSums = getHeight(root.left) + getHeight(root.right) + 1;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(maxDepthSums, Math.max(leftDiameter, rightDiameter));
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static int diameter = 0;

    public int getDiameterLinear(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getDiameterLinear(root.left);
        int rightHeight = getDiameterLinear(root.right);
        diameter = Math.max(diameter, 1 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        TreeDiameter obj = new TreeDiameter();
        obj.inorderDFS(root);
        System.out.println();
        System.out.println(obj.diameter(root));
        obj.getDiameterLinear(root);
        System.out.println(diameter);
    }
}
