package com.reactor.demo.reactor;

import java.util.Observable;
import java.util.Observer;

/**
 * com.reactor.demo.reactor
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 18:11
 */
public class ObserverDemo extends Observable {
    public static void main(String[] args) {
        ObserverDemo observerDemo = new ObserverDemo();
        observerDemo.addObserver((o, arg) -> {
            System.out.println("发生变化");
        });
        observerDemo.addObserver((o, arg) -> {
            System.out.println("手动被观察者通知！");
        });
        observerDemo.setChanged();  // 数据变化
        observerDemo.notifyObservers();   // 通知
    }
}
