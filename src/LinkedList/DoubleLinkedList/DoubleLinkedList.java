package LinkedList.DoubleLinkedList;

class MyDoubleLinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    public class Node<T> {          //Node 클래스
        T data;                     //데이터 저장
        Node<T> prev = null;        //다음 데이터의 위치 : front 도 노드 클래스 객체임
        Node<T> next = null;

        public Node(T data)         //Node 클래스 생성자
        {
            this.data = data;       //생성시 Node의 data에 입력온 data값을 저장
        }
    }

    public void addNode(T data) {   //노드 추가 메서드
        if(this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else { //while 안돌고 꼬리에 바로넣어도 될것같은데..? 커밋해두고 나중에 해봐야지
            Node<T> node = this.head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }


}

public class DoubleLinkedList {
    public static void main(String[] args) {

    }
}