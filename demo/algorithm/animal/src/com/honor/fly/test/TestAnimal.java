package com.honor.fly.test;

import com.honor.fly.AbstractAnimal;
import com.honor.fly.Cat;
import com.honor.fly.Dog;

import java.io.IOException;
import java.lang.reflect.*;

/**
 * test
 *
 * @author honor-ljp
 * 2023/2/2 21:00
 */

/**
 * 演示多态原理，注意加上下面的JVM参数，禁用指针压缩
 * -XX:UseCompressedOops -XX:UseCompressedClassPointers
 */
public class TestAnimal {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Cat cat = new Cat("这是只可爱的猫！");
        Dog dog = new Dog();
        Class<Cat> catClass = Cat.class;
        Class<?> aClass = Class.forName("com.honor.fly.Cat");
        System.out.println(aClass == catClass);
        Cat cat1 = (Cat) aClass.newInstance();
        Field nameField = aClass.getDeclaredField("name");
        int modifiers = nameField.getModifiers();
        boolean isPrivate = Modifier.isPrivate(modifiers);
        Method getName = aClass.getDeclaredMethod("getName", String.class);
        String invoke = (String) getName.invoke(cat, "机器猫");
        System.out.println(invoke);
        Field ageField = aClass.getDeclaredField("age");
        ageField.setAccessible(true);
        Integer catAge = (Integer) ageField.get(null);
        System.out.println(catAge);

        System.out.println(isPrivate);
        System.out.println("-----------------");
        Constructor<Cat> constructor = Cat.class.getConstructor(String.class);
        Cat cat2 = constructor.newInstance("超哥的猫！");
        String name = cat2.getName(null);
        System.out.println(name);
        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }
        whoEat(cat);
        whoEat(dog);
        System.in.read();
    }

    public static void whoEat(AbstractAnimal animal) {
        animal.eat();
    }
}
