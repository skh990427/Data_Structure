public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);

        MyLinkedList.delNode(3);

        MyLinkedList.delNode(1);

        MyLinkedList.delNode(5);

        MyLinkedList.printAll();

    }
}