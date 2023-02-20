package com.honor.fly.model;

import java.util.Arrays;

/**
 * com.honor.fly.model
 *
 * @author honor-ljp
 * 2023/1/26 18:01
 */
public class ChooseSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 7, 9, 2, 10, 1};
        sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int min;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
