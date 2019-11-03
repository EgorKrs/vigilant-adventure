package com.loneless.lInked_list;

public class List<Item> {

    private int size;
    private ListItem<Item> first;
    private ListItem<Item> last;

    List() {
        size = 0;
        first = null;
        last = null;
    }

    List(Item data) {
        first = last = new ListItem<Item>(data);
        size = 1;
    }

    public void add(Item data) {
        ListItem<Item> li = new ListItem<Item>(data);
        li.setNext(null);
        if (size >0) {
            li.setPrev(last);
            last.setNext(li);
        }
        else {
            first = li;
        }
        last = li;
        size++;
    }

    public ListItem<Item> getFirst() {
        return first;
    }

    public ListItem<Item> getLast() {
        return last;
    }

    public int getquan() {
        return size;
    }

    public ListItem<Item> get(int i) {
        if (i> size) {
            return null;
        }
        else {
            ListItem<Item> li = first;
            for (int j=1; j<i; j++) {
                li = li.getNext();
            }
            return li;
        }
    }

    public void remove(int i) {
        if (i <= size) {
            ListItem<Item> li = get(i);
            ListItem<Item> prev = li.getPrev();
            ListItem<Item> next = li.getNext();
            if (prev != null) {
                prev.setNext(next);
            }
            if (next != null) {
                next.setPrev(prev);
                if (i == 1) {
                    first = next;
                }
            }
            size--;
        }
    }

    public void swap(int i, int j) {
        if ((i <= size) && (j <= size) && (i < j)) {
            ListItem<Item> li1 = get(i);
            ListItem<Item> li2 = get(j);
            Item buf = li1.getData();
            li1.setData(li2.getData());
            li2.setData(buf);
        }
    }

}