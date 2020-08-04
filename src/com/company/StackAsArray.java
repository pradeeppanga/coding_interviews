package com.company;

import java.util.Stack;

public class StackAsArray {
    static final int MAX = 1000;
    int[] data = new int[MAX];
    int top;

    boolean isEmpty() {
        return (top < 0);
    }

    StackAsArray() {
        top = -1;
    }

    boolean push(int val) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack overflow");
            return false;
        } else {
            data[++top] = val;
            System.out.println(val + " pushed into stack.");
            return true;
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            return data[top--];
        }
    }

    int peek() {
        if (top < 0) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            return data[top];
        }
    }

    public static void main(String[] args) {
        StackAsArray stack = new StackAsArray();
        stack.push(23);
        stack.push(24);
        stack.push(22);
        stack.push(99);
        stack.push(28);
        stack.pop();
        stack.pop();
        stack.pop();

        int value = stack.pop();
        System.out.println(value);
        System.out.println(stack.peek());

        Stack<String> stack1 = new Stack<>();
        stack1.push("Pradeep");
        stack1.push("Panga");
        System.out.println(stack1.indexOf("Pradeep"));
    }
}