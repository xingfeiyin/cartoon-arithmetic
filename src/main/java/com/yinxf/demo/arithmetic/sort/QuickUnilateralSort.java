package com.yinxf.demo.arithmetic.sort;

import java.util.Arrays;

/**
 * 快速排序 单边循环法
 */
public class QuickUnilateralSort {

    public static void unilateralSort(int[] arr,int startIndex,int endIndex){
        //递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex){
            return;
        }

        //得到基准元素位置
        int pivotIndex = partition(arr,startIndex,endIndex);

        System.out.println("pivotIndex==="+pivotIndex);

        //得到基准元素，分成两部分进行递归排序
        unilateralSort(arr,startIndex,pivotIndex-1);
        unilateralSort(arr,pivotIndex+1,endIndex);
    }

    /**
     * 分治，单边循环法
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] arr,int startIndex,int endIndex){
        //取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex+1; i <= endIndex ; i++) {
            if (arr[i] < pivot){
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
            System.out.println("partition111==="+Arrays.toString(arr));
        }

        //pivot和指针重合点交换
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        System.out.println("partition222==="+Arrays.toString(arr));

        return mark;
    }


    public static void main(String[] args) {
        int[] arr = {4,4,6,5,3,2,8,1};
        unilateralSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
