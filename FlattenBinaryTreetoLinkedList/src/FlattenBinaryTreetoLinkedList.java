/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 17 Apr 2018
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/FlattenBinaryTreetoLinkedList
 **/

public class FlattenBinaryTreetoLinkedList {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private static TreeNode prev = null;

    private static void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    private static void printList(TreeNode head) {
        TreeNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.right != null ? "->" : ""));
            temp = temp.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
        printList(root);
    }

}
