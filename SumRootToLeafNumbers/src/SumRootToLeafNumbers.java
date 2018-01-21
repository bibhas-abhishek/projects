/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 21 Jan 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SumRootToLeafNumbers/
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 **/

public class SumRootToLeafNumbers {

    private static class Node {

        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(15);
        System.out.println(sumNumbers(root));
    }

    private static int sumNumbers(Node root) {
        return sumNumbersHelper(root, 0);
    }

    private static int sumNumbersHelper(Node root, int sum) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return sum * 10 + root.val;
        return sumNumbersHelper(root.left, sum * 10 + root.val) +
                sumNumbersHelper(root.right, sum * 10 + root.val);
    }

}
