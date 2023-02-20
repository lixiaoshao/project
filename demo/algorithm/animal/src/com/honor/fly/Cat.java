package com.honor.fly;

/**
 * PACKAGE_NAME
 *
 * @author honor-ljp
 * 2023/2/2 20:58
 */
public class Cat extends AbstractAnimal {
    static Integer age = 18;
    private String name;
    @Override
    public void eat() {
        System.out.println("猫骨头");
    }
    public String getName(String name) {
        if (name != null) {
            this.name = name;
        }
        return this.name;
    }
    public Cat() {

    }
    public Cat(String name) {
        this.name = name;
    }
}
