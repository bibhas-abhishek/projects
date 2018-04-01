/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 31 Mar 2018
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/RemoveLLElements
 **/
public class RemoveLLElements {

    private static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        ListNode head = null;
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        head = removeElementsItr(head, 2);
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode insertAtHead(ListNode head, int data) {
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

    private static ListNode removeElementsRec(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsRec(head.next, val);
        return head.val == val ? head.next : head;
    }

    private static ListNode removeElementsItr(ListNode head, int val) {
        if (head == null)
            return null;

        while (head != null && head.val == val)
            head = head.next;

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return head;
    }

}
