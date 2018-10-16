/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 21 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MergeSortLinkedList
 **/

public class MergeSortLinkedList {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode insert(ListNode head, int data) {
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

    private ListNode findMiddle(ListNode head) {
        if (head == null)
            return head;

        ListNode slowPtr = head;
        ListNode fastPtr = head.next;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    private ListNode mergeLists(ListNode headA, ListNode headB) {
        if (headA == null)
            return headB;

        if (headB == null)
            return headA;

        if (headA.val <= headB.val) {
            headA.next = mergeLists(headA.next, headB);
            return headA;
        } else {
            headB.next = mergeLists(headB.next, headA);
            return headB;
        }
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;     // break list from middle
        ListNode leftList = mergeSort(head);
        ListNode rightList = mergeSort(middleNext);
        return mergeLists(leftList, rightList);
    }

    public static void main(String[] args) {
        MergeSortLinkedList obj = new MergeSortLinkedList();
        ListNode head = null;
        head = obj.insert(head, 4);
        head = obj.insert(head, -1);
        head = obj.insert(head, 0);
        head = obj.insert(head, 1);
        head = obj.insert(head, 3);
        head = obj.insert(head, 2);

        obj.printList(head);
        head = obj.mergeSort(head);
        obj.printList(head);
    }

}
