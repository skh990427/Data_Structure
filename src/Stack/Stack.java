package Stack;

import java.util.ArrayList;

class MyStack<T> {
    private ArrayList<T> ms = new ArrayList<T>();

    public void push(T a) {
        ms.add(a);
    }
    public T pop() {
        if(ms.isEmpty())
            return null;
        return ms.remove(ms.size()-1);
    }
}

public class Stack {
    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<Integer>();

        ms.push(1);
        ms.push(2);
        ms.push(3);

        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());

    }
}