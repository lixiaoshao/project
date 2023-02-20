package com.honor.fly.model;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/26 15:27
 */
public class Student implements Comparable<Student> {
    private int age;
    private String username;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int age, String username) {
        this.age = age;
        this.username = username;
    }

    @Override
    public int compareTo(Student o) {
        return o.age - this.age;
    }
}
