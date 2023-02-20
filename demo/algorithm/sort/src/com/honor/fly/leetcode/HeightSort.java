package com.honor.fly.leetcode;

import java.util.Arrays;

/**
 * com.honor.fly.leetcode
 *
 * @author honor-ljp
 * 2023/1/26 16:42
 */
public class HeightSort {
    public static void main(String[] args) {
        String[] names = {"IEO","Sgizfdfrims","QTASHKQ","Vk","RPJOFYZUBFSIYp","EPCFFt","VOYGWWNCf","WSpmqvb"};
        int[] heights = {17233,32521,14087,42738,46669,65662,43204,8224};
        String[] sortNames = sortPeople(names, heights);
        System.out.println("sortNames = " + Arrays.toString(sortNames));
    }
    public static String[] sortPeople(String[] names, int[] heights) {
        int temp;
        int index;
        int[] arr = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            arr[i] = i;
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (heights[j] < heights[j + 1]) {
                    temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    index = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = index;
                }
            }
        }
        String[] newNames = new String[names.length];
        for (int i = 0; i < arr.length; i++) {
            newNames[i] = names[arr[i]];
        }
        return newNames;
    }
}
