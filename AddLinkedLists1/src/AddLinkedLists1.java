public class AddLinkedLists1 {

    public LinkedList.Node addTwoNumbers(LinkedList.Node l1, LinkedList.Node l2) {
        return addTwoLists(l1, l2, 0);
    }

    private LinkedList.Node addTwoLists(LinkedList.Node l1, LinkedList.Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedList.Node n = new LinkedList.Node();
        int val = carry;
        if (l1 != null) {
            val += l1.data;
        }

        if (l2 != null) {
            val += l2.data;
        }

        n.data = val % 10;
        n.next = addTwoLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
            val >= 10 ? 1 : 0);
        return n;
    }

    public static void main(String[] args) {
        AddLinkedLists1 driver = new AddLinkedLists1();
        LinkedList list1 = new LinkedList();
        list1.insertAtHead(3);
        list1.insertAtHead(4);
        list1.insertAtHead(5);
        list1.prettyPrintList();

        LinkedList list2 = new LinkedList();
        list2.insertAtHead(4);
        list2.insertAtHead(6);
        list2.insertAtHead(5);
        list2.prettyPrintList();

        LinkedList.Node head = driver.addTwoNumbers(list1.head, list2.head);
        LinkedList.Node.prettyPrintList(head);
    }
}
