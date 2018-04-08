/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Apr 2018
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SortedLLToBalancedBST
 **/
public class SortedLLToBalancedBST {

    private static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }

    }

    private static ListNode headNode = null;


    public static void main(String[] args) {
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);
        head = insert(head, 6);
        head = insert(head, 7);
        printList(head);
        System.out.println();
        TreeNode root = sortedListToBST(head);
        inorderDFS(root);
    }

    private static void inorderDFS(TreeNode root) {
        if (root == null)
            return;

        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }


    private static ListNode insert(ListNode head, int data) {
        if (head == null)
            head = new ListNode(data);
        else {
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new ListNode(data);
        }

        return head;
    }

    private static int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count = count + 1;
            head = head.next;
        }
        return count;
    }

    private static TreeNode sortedListToBST(ListNode head) {
        headNode = head;
        return sortedListToBSTUtil(getLength(head));
    }

    private static TreeNode sortedListToBSTUtil(int length) {
        if (length <= 0)
            return null;

        TreeNode tLeft = sortedListToBSTUtil(length / 2);
        TreeNode root = new TreeNode(headNode.val);
        root.left = tLeft;

        headNode = headNode.next;
        root.right = sortedListToBSTUtil(length - length / 2 - 1);
        return root;
    }

}
