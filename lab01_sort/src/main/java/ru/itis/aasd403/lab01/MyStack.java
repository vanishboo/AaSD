package ru.itis.aasd403.lab01;

import java.util.Arrays;

public class MyStack<T> {
    private Node top;
    private int size;



    class Node {
        public T value;
        public Node next;

        public Node(T value){
            this.value = value;
        }
    }

    public void push(T value) {
        Node temp = new Node(value);
        temp.next = top;
        top = temp;
        size++;
    }

    public T pop() {
        T v = top.value;
        top = top.next;
        size--;
        return v;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = top;
        while (current != null) {
            sb.append(current.value);
            current = current.next;
        }
        return sb.toString();
    }
}



