import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevelNodesBinaryTree {

    private static class Node {

        int  data;
        Node left, right, nextRight;

        public Node(int data) {
            this.data = data;
            left = right = null;
            nextRight = null;
        }
    }

    public void connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                node.nextRight = queue.peek();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else if (!queue.isEmpty()) { // null evaluated as the last popped element. add null again as delimiter.
                queue.offer(null);
            }
        }
    }

    public static void main(String[] args) {

        /* Constructed binary tree is
                  10
                /   \
              8      2
            /         \
          3            90
        */
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);

        new ConnectSameLevelNodesBinaryTree().connect(root);
        System.out.println("-1 is printed if there is no nextRight");
        System.out.println("nextRight of " + root.data + " is "
                           + ((root.nextRight != null) ? root.nextRight.data : -1));
        System.out.println("nextRight of " + root.left.data + " is "
                           + ((root.left.nextRight != null) ? root.left.nextRight.data : -1));
        System.out.println("nextRight of " + root.right.data + " is "
                           + ((root.right.nextRight != null) ? root.right.nextRight.data : -1));
        System.out
            .println("nextRight of " + root.left.left.data + " is "
                     + ((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1));
        System.out.println("nextRight of " + root.right.right.data + " is "
                           + ((root.right.right.nextRight != null) ? root.right.right.nextRight.data
                               : -1));
    }
}
