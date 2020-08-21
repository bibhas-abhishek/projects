public class OddEvenLinkedList {

    public LinkedList.Node oddEvenList(LinkedList.Node head) {
        if (head == null) {
            return null;
        }

        LinkedList.Node odd = head, even = head.next, eHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = eHead;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList driver = new OddEvenLinkedList();
        LinkedList list = new LinkedList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.prettyPrintList();
        list.head = driver.oddEvenList(list.head);
        list.prettyPrintList();
    }
}
