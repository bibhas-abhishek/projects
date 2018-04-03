private static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);
        head = insert(head, 6);
        printList(head);
        head = KReverse(head, 3);
        printList(head);
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node insert(Node head, int data) {
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
