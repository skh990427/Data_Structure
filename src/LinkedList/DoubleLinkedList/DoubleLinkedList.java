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

    public void printAll() {  //노드 출력 메서드
        if(this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);

            while (node.next != null)
            {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData) { //헤드부분에서 시작하여 값 서치
        if(this.head == null)
            return null;
        else {
            Node<T> node = this.head;
            while(node != null) {
                if(node.data == isData)
                    return node.data;
                else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public T searchFromTail(T isData) { //꼬리부분에서 시작하여 값 서치
        if(this.head == null)
            return null;
        else {
            Node<T> node = this.tail;
            while(node != null) {
                if(node.data == isData)
                    return node.data;
                else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public boolean PrevFrontAddNode(T isData, T data) { //isData 앞에 data를 추가하기
        if(this.head == null)               //머리가 null이면 false리턴
            return false;
        else {
            Node<T> node = this.head;
            if(node.data == isData) {
                Node<T> addnode = new Node<>(data);

                this.head = addnode;        //현재의 헤드를 추가된 노드로 변경
                addnode.next = node;        //추가된 노드의 다음노드는 미리 헤드를 넣어뒀던 node
                node.prev = addnode;        //node의 이전노드를 추가된 노드로 변경
                return true;
            }

            while (node.next != null) {
                if (node.data == isData) {  //리스트를 순회하다가 찾고있는 데이터와 만나면
                    Node<T> addnode = new Node<>(data);

                    addnode.prev = node.prev;   //추가노드의 이전노드는 기존의 노드의 앞부분으로 지정
                    addnode.next = node;        //추가노드의 다음노드는 기존의 노드로 지정
                    node.prev.next = addnode;   //선택된 노드 이전의 다음노드를 추가노드로 지정
                    return true;
                }
                node = node.next; //if문에 들어가지 못한다면 node를 다음노드로 순회
            }
            return false; //while을 빠져나올때까지 if문에서 노드선택을 못했다면, false 리턴
        }
    }

    public boolean delNode(T isData) { //그 노드가 있는지 검사하고 삭제
        if (this.head == null) {
            return false;   //헤드가 없으면 null 리턴
        } else {
            if (this.head.data == isData) {//헤드의 data가 삭제할 값이면
                this.head = this.head.next; //헤드를 헤드 다음노드로 교체
            } else {
                Node<T> node = this.head;
                while (node.next != null) {
                    if (node.data == isData) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;

                        return true;
                    }
                    node = node.next;
                }
            }
            return false;
        }
    }
}

public class DoubleLinkedList {
    public static void main(String[] args) {
        MyDoubleLinkedList<Integer> mdll = new MyDoubleLinkedList<>();

        mdll.addNode(2);
        mdll.addNode(4);
        mdll.addNode(8);
        mdll.addNode(3);
        mdll.addNode(5);

        mdll.printAll();

        System.out.println("머리부터 찾기 : " + mdll.searchFromHead(10));
        System.out.println("꼬리부터 찾기 : " + mdll.searchFromTail(5));

        System.out.println("나는 8앞에 10을 추가할꺼야!");
        mdll.PrevFrontAddNode(8, 10);

        mdll.printAll();

        System.out.println("나는 2앞에 11을 추가할꺼야!");
        mdll.PrevFrontAddNode(2, 11);

        mdll.printAll(); // 여기서는 11 2 4 10 8 3 5가 나옴
        System.out.println("나는 11이랑 10이랑 123123을 지울꺼야!");
        mdll.delNode(11);
        mdll.delNode(10);
        mdll.delNode(123123); //값이 없기에 변화X

        //결과는 2 4 8 3 5 나와야함

        mdll.printAll();
    }
}
