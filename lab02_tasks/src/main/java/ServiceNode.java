package ru.itis.inf403.lab02.object.linkList;

public class ServiceNode<T> {
    private Node head; // Начало списка


    private class Node {
        public T value;
        public Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = findLast();
        last.next = newNode;
    }

    public void add(int position, T value) {
        Node newNode = new Node(value);
        Node curNode = findN(position);
        findN(position - 1).next = newNode;
        newNode.next = curNode;
    }

    private Node findLast() {
        if (head == null) return null;
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }


    public Node findN(int n) {
        if (head == null || n < 0) return null;
        Node current = head;
        for (int i = 0; i < n; i++) {
            if (current.next == null) return null; // Защита от выхода за границы
            current = current.next;
        }
        return current;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public int size() {
        Node current = head;
        int cnt = 0;
        if (head == null) return 0;
        while (current.next != null) {
            current = current.next;
            cnt++;
        }
        return cnt+1;
    }
    public void remove(int n) {
        if (n == 0) { // Удаляем первый элемент
            head = head.next;
            return;
        }

        Node prev = findN(n - 1); // Узел перед удаляемым
        Node toDelete = prev.next;

        if (toDelete != null) {
            prev.next = toDelete.next; // Перепрыгиваем удаляемый узел
            toDelete.next = null; // Очищаем ссылку
        }
    }
    // Вывод списка
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }
}
