package com.loneless.homevork.task02.stack;

import com.loneless.homevork.task02.stack.logic_and_impl.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printStack();
        stack.push(5);
        stack.push(14);
        stack.push(3);
        stack.push(23);
        stack.printStack();
        System.out.print("\npoped: " + stack.pop());
        System.out.print("\npoped: " + stack.pop());
        stack.printStack();

    }
}
