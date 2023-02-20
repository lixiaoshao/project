package com.honor.fly.test;

import com.honor.fly.model.CircleList;

/**
 * com.honor.fly.test
 *
 * @author honor-ljp
 * 2023/1/27 16:11
 */
public class JosephusTest {
    public static void main(String[] args) {
        CircleList.Node<Integer> circle = CircleList.circle(41);
        int count = 0;
        CircleList.Node<Integer> curr = circle.next;
        CircleList.Node<Integer> pre = null;
        while (!curr.equals(curr.next)) {
            count++;
            if (count == 3) {
                // 删除当前节点
                pre.next = curr.next;
                // 打印当前节点
                System.out.printf("%d\t", curr.item);
                // 重置count
                count = 0;
                // 让当前节点后移
                curr = curr.next;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        System.out.printf("%d\t", curr.item);
    }
}
