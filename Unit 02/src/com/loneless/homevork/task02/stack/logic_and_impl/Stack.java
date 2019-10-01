package com.loneless.homevork.task02.stack.logic_and_impl;

import com.loneless.homevork.task02.stack.data.Item;

public class Stack {

    private Item top;

    public void push(int data) {
        if (null == top) {
            top = new Item(data);
        } else {
            Item item = new Item(data);
            item.setNext(top);
            top = item;
        }
    }


    public int pop() {
        int data = top.getData();

        top = top.getNext();
        return data;
    }


    public void printStack() {
        Item tmp = top;

        if (top == null) {
            System.out.print("Stack is empty !!");
        }
        System.out.println();
        while (tmp != null) {
            System.out.print(" > " + tmp.getData());
            tmp = tmp.getNext();
        }
    }
}
