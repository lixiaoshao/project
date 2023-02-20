package com.honor.fly.test;

import com.honor.fly.model.Student;

/**
 * com.honor.fly.test
 *
 * @author honor-ljp
 * 2023/1/26 15:29
 */
public class StudentTest {
    public static void main(String[] args) {
        Student st1 = new Student(50, "张三");
        Student st2 = new Student(30, "李四");
        int diff = st1.compareTo(st2);
        Student max;
        if (diff < 0) {
            // 说明st2比st1小
            max = st1;
        } else {
            max = st2;
        }
        System.out.println("max = " + max);
    }
}
