package com.company;

import java.util.NoSuchElementException;

// add() to last, remove() and peek() from first
public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }
    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data) {
        QueueNode<T> t = new QueueNode<>(data);
        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        MyQueue<String> queue1 = new MyQueue<>();
        queue1.add("Pradeep");
        queue1.add("Kumar");
        queue1.add("Panga");
        System.out.println(queue1.peek());
        queue1.remove();
        System.out.println(queue1.peek());
        System.out.println(queue1.peek());
    }
}
