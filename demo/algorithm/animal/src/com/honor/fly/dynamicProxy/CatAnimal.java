package com.honor.fly.dynamicProxy;

/**
 * com.honor.fly.dynamicProxy
 *
 * @author honor-ljp
 * 2023/2/3 17:54
 */
public class CatAnimal extends AbstractAnimal implements Animal {
    @Override
    public void eat() {
        System.out.println(": 猫吃的很香啊！");
    }

    @Override
    public String getName() {
        return "可爱的猫";
    }
}
