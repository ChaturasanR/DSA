public class LinkedList {
    private LinkedListNode head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    };

    public LinkedListNode getHead() {
        return this.head;
    }

    public void addNodeAtLast(int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (this.head == null) {
            this.head = node;
            this.size++;
            return;
        }

        LinkedListNode temp = this.head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext((node));
        this.size++;
    }

    public void removeLastNode() {
        if (this.head == null) {
            return;
        }

        LinkedListNode temp = this.head;
        while (temp.getNext() != null && temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        this.size--;
    }

    public void insertAtKthIndex(int data, int k) {

        if (size <= k) {
            addNodeAtLast(data);
            return;
        }

        LinkedListNode node = new LinkedListNode(data);
        LinkedListNode temp = this.head;
        while (temp.getNext() != null && k > 1) {
            temp = temp.getNext();
            k--;
        }

        if (temp.getNext() != null)
            node.setNext(temp.getNext());
        temp.setNext(node);
        this.size++;
    }

    public void deleteAtKthIndex(int k) {
        if (size <= k) {
            removeLastNode();
            return;
        }

        if (k == 0) {
            this.head = head.getNext();
            this.size--;
        }

        LinkedListNode temp = this.head;

        while (temp.getNext() != null && k > 1) {
            temp = temp.getNext();
            k--;
        }

        temp.setNext(temp.getNext() != null ? temp.getNext().getNext() : null);
        this.size--;
    }

    public int getSize() {
        return this.size;
    }

    public void printLinkedList() {
        LinkedListNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
