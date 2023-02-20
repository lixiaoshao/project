package com.honor.model;

import org.w3c.dom.Node;

import java.util.Iterator;

/**
 * com.honor.model
 *
 * @author honor-ljp
 * 2023/1/27 16:55
 */
public class Stack<T> implements Iterable {
    private Node head;
    private int N;
    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public T pop() {
        Node first = head.next;
        if (first == null) {
            return null;
        }
        head.next = first.next;
        N--;
        return first.item;
    }
    public void push(T t) {
        // 找到首节点
        Node first = head.next;
        // 创建新节点
        Node newNode = new Node(t, null);
        // 首节点指向新节点
        head.next = newNode;
        // 新节点指向原来的第一个节点
        newNode.next = first;
        N++;
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    public class SIterator implements Iterator {
        private Node curr;
        public SIterator() {
            this.curr = head;
        }
        @Override
        public boolean hasNext() {
            return curr.next != null;
        }

        @Override
        public Object next() {
            curr = curr.next;
            return curr.item;
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
