import java.util.Random;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 20 Apr 2018
 * https://leetcode.com/problems/linked-list-random-node/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LinkedListRandomNode
 **/

public class LinkedListRandomNode {

    private static ListNode head = null;

    private static Random random = new Random();

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
            this.next = null;
        }

    }

    private static int getRandom() {
        int count = 0;
        int result = -1;
        ListNode dummy = head;
        while (dummy != null) {
            count += 1;
            if (random.nextInt(count) == 0)
                result = dummy.val;
            dummy = dummy.next;
        }
        return result;
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

    public static void main(String[] args) {
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);
        head = insert(head, 6);
        System.out.println(getRandom());
    }

}
