package LinkedList.SingleLinkedList;

class MySingleLinkedList<T> {
    public Node<T> head = null;     //노드 클래스 객체 head 선언

    public class Node<T> {          //Node 클래스
        T data;                     //데이터 저장
        Node<T> next = null;        //다음 데이터의 위치 : next 도 노드 클래스 객체임

        public Node(T data)         //Node 클래스 생성자
        {
            this.data = data;       //생성시 Node의 data에 입력온 data값을 저장
        }
    }

    public void addNode(T data)     //SingleLinkedList에 노드를 추가하는 메서드
    {
        if(head == null)            //만약 head가 null이라면
        {
            head = new Node<T>(data);   //head에 새로운 노드<T>(data값)과, next = null값을 저장   어쩄든 head도 Node클래스 객체이기때문에 들어가도 문제없음
        }
        else                        //만약 head객체가 null이 아니라면 말그대로 head객체에 다른 Node 객체가 있다면(?)
        {
            Node<T> node = this.head;   //node라는 Node 클래스객체를 선언하여 거기다가 head객체를 넣어준다.
            while(node.next != null)    //node 객체의 next가 null값이 아니라면 (반복)
            {
                node = node.next;       //node 객체에는 node의 next객체를 넣어준다.
            }
            node.next = new Node<T>(data); //그렇게 마지막까지 오면 node객체의 next객체는 = null값이기때문에 node.next = 에 새로운 Node 객체를 생성하여 넣어준다.
        }
    }

    public void printAll()
    {
        if(head != null)
        {
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null)
            {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data)
    {
        if(this.head == null)
        {
            return null;
        }
        else
        {
            Node<T> node = this.head;
            while(node.next != null)
            {
                if(node.data == data)
                    return node;
                else
                    node = node.next;
            }
        }
        return null;
    }

    public void addNodeinside(T data, T isData)
    {
        Node<T> searchedNode = this.search(isData);

        if(searchedNode == null)
            this.addNode(data);
        else
        {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }
    }

    public boolean delNode(T isData)
    {
        if(this.head == null)
            return false;
        else
        {
            Node<T> node = this.head;
            if(node.data == isData)
            {
                this.head = this.head.next;
                return true;
            }
            else
            {
                while(node.next != null)
                {
                    if(node.next.data == isData)
                    {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }
}

public class SingleLinkedList {
    public static void main(String[] args) {
        MySingleLinkedList<Integer> MyLinkedList = new MySingleLinkedList<Integer>();

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