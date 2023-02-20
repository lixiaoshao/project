package com.spring5.demo.service;

/**
 * com.spring5.demo.service
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 10:09
 */
public class LifeCycle {
    private String name;

    public void setName(String name) {
        System.out.println("第二步：为bean的属性设置值和对其他bean引用！");
        this.name = name;
    }

    public LifeCycle() {
        System.out.println("第一步：默认无参构造创建bean实例！");
   }
   public void initMethod() {
       System.out.println("第四步：初始化方法！");
   }
   public void destroyMethod() {
       System.out.println("第七步：销毁bean！");

   }
}
