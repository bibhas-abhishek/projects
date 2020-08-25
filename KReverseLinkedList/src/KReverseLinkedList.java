public class KReverseLinkedList {

    public LinkedList.Node reverse(LinkedList.Node head) {
        LinkedList.Node currentNode = head;
        LinkedList.Node prevNode = null;
        LinkedList.Node nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    public LinkedList.Node KReverse(LinkedList.Node head, int k) {
        LinkedList.Node currentNode = head;
        LinkedList.Node prevNode = null;
        LinkedList.Node nextNode = null;
        int count = k;
        while (currentNode != null && count > 0) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            count--;
        }

        if (nextNode != null) {
            head.next = KReverse(nextNode, k);
        }
        return prevNode;
    }

    public static void main(String[] args) {
        KReverseLinkedList driver = new KReverseLinkedList();
        LinkedList list = new LinkedList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtTail(6);
        list.prettyPrintList();
        list.head = driver.KReverse(list.head, 3);
        list.prettyPrintList();
    }
}
