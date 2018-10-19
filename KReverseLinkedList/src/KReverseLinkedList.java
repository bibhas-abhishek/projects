/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 19 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/KReverseLinkedList
 */

public class KReverseLinkedList {

    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public Node insert(Node head, int data) {
        if (head == null)
            head = new Node(data);
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node(data);
        }
        return head;
    }

    public Node reverse(Node head) {
        Node currentNode = head;
        Node prevNode = null;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
        return head;
    }

    public Node KReverse(Node head, int k) {
        Node currentNode = head;
        Node prevNode = null;
        Node nextNode = null;
        int count = k;
        while (currentNode != null && count > 0) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            count--;
        }
        if (nextNode != null)
            head.next = KReverse(nextNode, k);
        return prevNode;
    }

    public static void main(String[] args) {
        KReverseLinkedList obj = new KReverseLinkedList();
        Node head = null;
        head = obj.insert(head, 1);
        head = obj.insert(head, 2);
        head = obj.insert(head, 3);
        head = obj.insert(head, 4);
        head = obj.insert(head, 5);
        head = obj.insert(head, 6);
        obj.printList(head);
        head = obj.KReverse(head, 3);
        obj.printList(head);
    }

}
