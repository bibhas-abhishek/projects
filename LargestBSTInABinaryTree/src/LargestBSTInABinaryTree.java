/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 12 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/LargestBSTInABinaryTree
 **/

public class LargestBSTInABinaryTree {

    private static class Aux {

        int min;
        int max;
        int size;
        boolean isBST;

        Aux() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            size = 0;
            isBST = true;
        }

    }

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    private static Aux getMaxBST(Node root) {
        if (root == null)
            return new Aux();

        Aux leftAux = getMaxBST(root.left);
        Aux rightAux = getMaxBST(root.right);

        Aux aux = new Aux();

        if (!leftAux.isBST || !rightAux.isBST || root.data < leftAux.max || root.data >= rightAux.min) {
            aux.isBST = false;
            aux.size = Math.max(leftAux.size, rightAux.size);
            return aux;
        }

        aux.isBST = true;
        aux.size = leftAux.size + rightAux.size + 1;
        aux.min = root.left == null ? root.data : leftAux.min;
        aux.max = root.right == null ? root.data : rightAux.max;
        return aux;
    }

    public static void main(String[] args) {
        Node root = new Node(25);
        root.left = new Node(18);
        root.right = new Node(50);
        root.left.left = new Node(19);
        root.left.right = new Node(20);
        root.right.left = new Node(35);
        root.right.right = new Node(60);
        root.left.left.right = new Node(15);
        root.left.right.left = new Node(18);
        root.left.right.right = new Node(25);
        root.right.left.left = new Node(20);
        root.right.left.right = new Node(40);
        root.right.right.left = new Node(55);
        root.right.right.right = new Node(70);
        root.right.left.left.right = new Node(25);
        System.out.println(getMaxBST(root).size);
    }

}
