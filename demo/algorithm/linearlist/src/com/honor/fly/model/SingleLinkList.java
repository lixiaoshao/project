package com.honor.fly.model;

import java.util.Iterator;

/**
 * com.honor.fly.model
 *
 * @author honor-ljp
 * 2023/1/27 10:38
 */
public class SingleLinkList<T> implements Iterable {
    private Node head;
    private int N;

    public SingleLinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        head.next = null;
        this.N = 0;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int length() {
        return N;
    }
    public T get(int i) {
        Node newNext = head.next;
        for (int index = 0; index < i; index++) {
            newNext = newNext.next;
        }
        return newNext.item;
    }
    public void insert(T t) {
        Node newNext = head;
        while (newNext.next != null) {
            newNext = newNext.next;
        }
        newNext.next = new Node(t, null);
        N++;
    }
    public void insert(int i, T t) {
        Node newNext = head;
        for (int index = 0; index < i; index++) {
            newNext = newNext.next;
        }
        Node nextNode = newNext.next;
        newNext.next = new Node(t, nextNode);
        N++;
    }
    public T remove(int i) {
        Node newNext = head;
        for (int index = 0; index < i; index++) {
            newNext = newNext.next;
        }
        Node curr = newNext.next;
        newNext.next = curr.next;
        N--;
        return curr.item;
    }
    public int indexOf(T t) {
        Node curr = head.next;
        for (int i = 0; i < N; i++) {
            if (curr.item.equals(t)) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }
    public void reverse() {
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }
    public Node reverse(Node curr) {
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }
        // 最后一个节点反转后就作为当前节点的上一个节点
        // 所以：上一个节点的下一个节点是当前节点
        // 当前节点的下一个节点为null
        Node pre = reverse(curr.next);
        curr.next = null;
        pre.next = curr;
        return curr;
    }

    @Override
    public Iterator iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator {
        private Node node;
        public TIterator() {
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }

    public class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
