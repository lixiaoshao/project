package com.honor.fly.test;

import com.honor.fly.model.SingleLinkList;

/**
 * com.honor.fly.test
 *
 * @author honor-ljp
 * 2023/1/27 11:07
 */
public class SingleLinkListTest {
    public static void main(String[] args) {
        SingleLinkList<String> singleLinkList = new SingleLinkList<>();
        singleLinkList.insert("张三");
        singleLinkList.insert("李四");
        singleLinkList.insert("王五");
        singleLinkList.insert(1, "张三的后边位置");
        singleLinkList.forEach(System.out::println);
        int index = singleLinkList.indexOf("李四");
        System.out.println("李四出现的位置 = " + index);
        System.out.println("----------------------------");
        String s = singleLinkList.get(1);
        System.out.println("第一个元素 = " + s);
        /*String item = singleLinkList.remove(1);
        System.out.println("删除第一个元素是 = " + item);
        singleLinkList.clear();
        System.out.println("length = " + singleLinkList.length());*/
        System.out.println("------------reverse测试：-------------");
        singleLinkList.reverse();
        singleLinkList.forEach(System.out::println);

    }
}
