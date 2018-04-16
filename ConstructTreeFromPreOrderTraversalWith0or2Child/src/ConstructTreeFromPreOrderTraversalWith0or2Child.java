/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 16 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ConstructTreeFromPreOrderTraversalWith0or2Child
 **/

public class ConstructTreeFromPreOrderTraversalWith0or2Child {

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    private static int index = 0;

    private static Node createTree(int pre[], char val[]) {
        return createTreeUtil(pre, val);
    }

    private static Node createTreeUtil(int pre[], char val[]) {
        if (index >= pre.length) {
            return null;
        }

        Node root = new Node(pre[index]);
        if (val[index] == 'L') {
            index++;
        } else {
            index++;
            root.left = createTreeUtil(pre, val);
            root.right = createTreeUtil(pre, val);
        }
        return root;
    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    public static void main(String args[]) {
        int pre[] = {10, 30, 20, 5, 15};
        char val[] = {'N', 'N', 'L', 'L', 'L'};
        Node root = createTree(pre, val);
        inorderDFS(root);
    }

}
