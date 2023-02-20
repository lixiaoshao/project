package com.honor.fly.model;

import java.util.Arrays;

/**
 * com.honor.fly.model
 *
 * @author honor-ljp
 * 2023/1/26 16:11
 */
public class BubbleSort {
    public static void main(String[] args) {
        // 输入：456321
        // 输出：123456
        int[] arr = {4, 5, 6, 3, 2, 1};
        sort(arr);
        System.out.println("sort = " + Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        // 交换数据用的临时变量
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            // 多少个数据参与排序  第一次: 全部 第二次： 全部 - 1 最后一次 就是 1
            // 比较相邻的数据，从哪儿开始比较呢？ 从0开始比较 到 i
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
