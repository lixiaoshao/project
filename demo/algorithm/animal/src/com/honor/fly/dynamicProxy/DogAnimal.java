package com.honor.fly.dynamicProxy;

/**
 * com.honor.fly.dynamicProxy
 *
 * @author honor-ljp
 * 2023/2/3 17:56
 */
public class DogAnimal extends AbstractAnimal implements Animal {
    @Override
    public void eat() {
        System.out.println(": 小狗吃的也很香啊！");
    }

    @Override
    public String getName() {
        return "这是小狗";
    }
}
