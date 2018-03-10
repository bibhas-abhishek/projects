public class HeightAndTotalHeightBST {

    private static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    private static int totalHeight;

    public static void main(String[] args) {
        int[] n = new int[]{500, 400, 300, 450, 425, 475, 600, 550, 400, 450};
        Node root = buildTree(n);
        calcTotalHeight(root);
        System.out.println(getHeight(root));
        System.out.println(totalHeight);
    }

    private static Node buildTree(int[] array) {
        Node root = null;
        for (int i = 0; i < array.length; i++)
            if (!ifKeyExists(root, array[i]))
                root = insertNode(array[i], root);
        return root;
    }

    private static Node insertNode(int i, Node root) {
        if (root == null) {
            root = new Node(i);
            return root;
        }
        if (i < root.data)
            root.left = insertNode(i, root.left);
        else
            root.right = insertNode(i, root.right);
        return root;
    }

    private static void calcTotalHeight(Node root) {
        if (root == null)
            return;
        calcTotalHeight(root.left);
        totalHeight += getHeight(root);
        calcTotalHeight(root.right);
    }

    private static int getHeight(Node root) {
        if (root == null)
            return -1;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static boolean ifKeyExists(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key < root.data)
            return ifKeyExists(root.left, key);
        else
            return ifKeyExists(root.right, key);
    }

}
