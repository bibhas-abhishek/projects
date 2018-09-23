/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MorrisTraversal
 **/

public class MorrisTraversal {

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    private static int count = 0;

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        morrisTraversalInorder(root);
        /*System.out.println();
        System.out.println(count);
        System.out.println(findMedian(root));*/
    }

    private static void morrisTraversalInorder(Node root) {
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current; // make threaded link
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.data + " "); // move this to upper if for pre order traversal
                    current = current.right;
                }
            }
        }
    }

    private static boolean isOdd(int currentCount) {
        return count % 2 != 0 && currentCount == (count + 1) / 2;
    }

    private static boolean isEven(int currentCount) {
        return count % 2 == 0 && currentCount == count / 2;
    }

    private static double findMedian(Node root) {
        Node current = root;
        Node previous = root;
        int count = 0;
        while (current != null) {
            if (current.left == null) {
                count++;
                if (isEven(count))
                    return (current.data + previous.data) / 2.0;
                else if (isOdd(count))
                    return current.data;
                previous = current;
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current; // make threaded link
                    current = current.left;
                } else {
                    predecessor.right = null;
                    count++;
                    if (isEven(count))
                        return (current.data + previous.data) / 2.0;
                    else if (isOdd(count))
                        return current.data;
                    previous = current;
                    current = current.right;
                }
            }
        }
        return -1;
    }

}
