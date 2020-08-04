package com.company;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private T min;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
            this.min = data;
        }
    }
    private StackNode<T> top;

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T data) {
        StackNode<T> item = new StackNode<T>(data);
        // top -> next item -> ... => item -> old(top) -> next item -> ...
        if(item.min < top.min) {

        }
        item.next = top;
        top = item;
    }

    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack1 = new MyStack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);
        stack1.push(9);
        stack1.push(10);

        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        stack1.push(11);
        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
    }
}
