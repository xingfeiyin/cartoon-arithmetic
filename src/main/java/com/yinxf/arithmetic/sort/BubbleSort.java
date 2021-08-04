package com.yinxf.arithmetic.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            System.out.println("i===="+i);
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            //无须数组的边界，每次比较只需要比到这里为止
            int sortBorder = array.length -1 ;
            for (int j = 0; j < sortBorder; j++) {
                System.out.println("j===="+j);
                int tmp = 0;
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] =tmp;
                    //因为有元素进行交换，所以不是有序的，标记变为false
                    isSorted = false;
                    //把无须数组的边界更新为最后一次交换元素的位置
                    sortBorder = j;
                    System.out.println("issorted="+isSorted);
                    System.out.println("sortBorder="+sortBorder);
                }
            }

            if (isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3,4,2,1,5,6,7,8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
