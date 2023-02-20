package com.honor.fly.test;

import com.honor.fly.model.Goods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * com.honor.fly.test
 *
 * @author honor-ljp
 * 2023/1/26 15:35
 */
public class GoodsTest {
    public static void main(String[] args) {
        Goods goods1 = new Goods(500, "上衣", 200);
        Goods goods2 = new Goods(300, "裤子", 100);
        Goods goods3 = new Goods(300, "裤子", 300);
        List<Goods> list = new ArrayList<>();
        list.add(goods1);
        list.add(goods2);
        list.add(goods3);

        // 需求是物美价廉： 价格低先排序 -> 销量高的
        Comparator<Goods> comparator = (o1, o2) -> {
            int result = (int) (o1.getPrice() - o2.getPrice());
            if (result >= 0) {
                return -(o1.getSaleNum() - o2.getSaleNum());
            }
            return result;
        };
        list.sort(comparator);
        list.forEach(System.out::println);
    }
}
