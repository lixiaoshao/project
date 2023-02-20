package com.honor.fly.leetcode;

/**
 * com.honor.fly.leetcode
 *
 * @author honor-ljp
 * 2023/1/27 12:08
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        listNode = rotateRight(listNode, 2);
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode currNode = head;
        int len = 1;
        while (currNode.next != null) {
            currNode = currNode.next;
            len++;
        }
        k = k % len;
        for (int i = 0; i < k; i++) {
            head = moveLastNode(head);
        }
        return head;
    }
    static ListNode moveLastNode(ListNode head) {
        ListNode firstNode = head;
        ListNode currNode = head;
        ListNode lastPreNode = null;
        ListNode lastNode;
        while (currNode.next != null) {
            lastPreNode = currNode;
            currNode = currNode.next;
        }
        if (lastPreNode == null) {
            // 只有一个节点
            return firstNode;
        }
        lastNode = lastPreNode.next;
        // 倒数第二个节点作为尾节点
        lastPreNode.next = null;
        // 倒数第一个节点的下一个节点是第一个节点
        lastNode.next = firstNode;
        return lastNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
