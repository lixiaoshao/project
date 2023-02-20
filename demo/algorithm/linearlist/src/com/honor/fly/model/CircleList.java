package com.honor.fly.model;

/**
 * com.honor.fly.model
 *
 * @author honor-ljp
 * 2023/1/27 15:54
 */
public class CircleList {
    public static void main(String[] args) {
        Node circle = circle(41);
        print(circle);
    }
    public static void print(Node circle) {
        Node first = circle.next;
        Node curr = circle.next;
        while (first != curr.next) {
            System.out.printf("%d\t", curr.item);
            curr = curr.next;
        }
    }
    public static class Node<T> {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    public static Node<Integer> circle(int len) {
        Node<Integer> first = null;
        Node<Integer> pre = null;
        for (int i = 1; i <= len; i++) {
            Node<Integer> newNode = new Node(i, null);
            if (i == 1) {
                first = newNode;
                pre = first;
                continue;
            }
            pre.next = newNode;
            pre = newNode;
            if (i == len) {
                pre.next = first;
            }
        }
        return pre;
    }
}
