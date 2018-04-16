public class Tree {

private static class Node {

int data;
Node left;
Node right;

Node(int data) {
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

private static void inorderDFS(Node root) {
        if (root == null)
                return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
}

private static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
                System.out.print(queue.peek().val + " ");
                TreeNode temp = queue.poll();
                if (temp.left != null)
                        queue.add(temp.left);
                if (temp.right != null)
                        queue.add(temp.right);
        }
}

}
