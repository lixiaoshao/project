package com.honor.test;

import com.honor.model.Stack;

/**
 * com.honor.test
 *
 * @author honor-ljp
 * 2023/1/27 17:21
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.forEach(System.out::println);
        System.out.println("--------------------");
        String result = stack.pop();
        System.out.println("弹出的元素：" + result);
        stack.forEach(System.out::println);
    }
}
