package Queue;

import java.util.ArrayList;

class MyQueue<T> {
    private ArrayList<T> queue = new ArrayList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (queue.isEmpty())
            return null;
        return queue.remove(0);
    }
}

public class Queue {
    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<Integer>();

        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);

        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());

        System.out.println(mq.dequeue());
    }
}