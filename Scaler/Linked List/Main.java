public class Main {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addNodeAtLast(2);
        ll.addNodeAtLast(4);
        ll.addNodeAtLast(6);
        ll.addNodeAtLast(8);
        SizeOfLL sizeOfLL = new SizeOfLL();
        System.out.println(sizeOfLL.getSize(ll.getHead()));
        System.out.println(ll.getSize());

        ll.insertAtKthIndex(5, 3);

        ll.printLinkedList();
        System.out.println(ll.getSize());

        ll.deleteAtKthIndex(1);
        ll.deleteAtKthIndex(5);
        System.out.println(ll.getSize());
        ll.printLinkedList();
    }

}
