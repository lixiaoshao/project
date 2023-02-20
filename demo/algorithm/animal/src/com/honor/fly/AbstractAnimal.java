package com.honor.fly;

/**
 * PACKAGE_NAME
 *
 * @author honor-ljp
 * 2023/2/2 20:56
 */
public abstract class AbstractAnimal {
    public abstract void eat();

    @Override
    public String toString() {
        return "我是：" + this.getClass().getSimpleName();
    }
}
