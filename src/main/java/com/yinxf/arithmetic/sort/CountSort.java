package com.yinxf.arithmetic.sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountSort {
    public static void main(String[] args) {
        int[] array = {95,94,91,98,99,90,99,93,91,92};
        int[] sorted = sort(array);
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] sort(int[] array) {
        //得到数组的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }

        int d = max - min;
        //创建统计数组并统计对应元素的个数
        int[] countArray = new int[d+1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]-min]++;
        }

        //统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i <countArray.length ; i++) {
            countArray[i] += countArray[i-1];
        }
        //倒序遍历原始数列，从统计数组找到正确的位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length-1; i >= 0 ; i--) {
            sortedArray[countArray[array[i]-min] - 1] = array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;
    }

}
