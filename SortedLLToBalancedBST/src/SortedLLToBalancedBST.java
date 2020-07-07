/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 03 Apr 2018
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SortedLLToBalancedBST
 **/

public class SortedLLToBalancedBST {

    private static class ListNode {

        int      val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    private ListNode headNode = null;

    private void inorderDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    private void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    // add nodes to tail
    private ListNode insert(ListNode head, int data) {
        if (head == null) {
            head = new ListNode(data);
        }
        else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(data);
        }
        return head;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count += 1;
            head = head.next;
        }
        return count;
    }

    private TreeNode sortedListToBSTUtil(int length) {
        if (length <= 0) {
            return null;
        }

        TreeNode tLeft = sortedListToBSTUtil(length / 2);
        TreeNode root = new TreeNode(headNode.val);
        root.left = tLeft;
        headNode = headNode.next;
        root.right = sortedListToBSTUtil(length - length / 2 - 1); // length - left tree nodes - root
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        headNode = head;
        return sortedListToBSTUtil(getLength(head));
    }

    public static void main(String[] args) {
        SortedLLToBalancedBST obj = new SortedLLToBalancedBST();
        ListNode head = null;
        head = obj.insert(head, 1);
        head = obj.insert(head, 2);
        head = obj.insert(head, 3);
        head = obj.insert(head, 4);
        head = obj.insert(head, 5);
        head = obj.insert(head, 6);
        head = obj.insert(head, 7);
        obj.printList(head);
        System.out.println();
        TreeNode root = obj.sortedListToBST(head);
        obj.inorderDFS(root);
    }
}
