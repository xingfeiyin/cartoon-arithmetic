package com.yinxf.arithmetic.sort;

import java.util.Arrays;

/**
 * 快速排序：双边循环法
 */
public class QuickBilateralSort {

    /**
     * 双边循环法快速排序
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void bilateralSort(int[] arr,int startIndex,int endIndex){
        //递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex){
            return;
        }

        //得到基准元素位置
        int pivotIndex = partition(arr,startIndex,endIndex);

        System.out.println("pivotIndex==="+pivotIndex);

        //得到基准元素，分成两部分进行递归排序
        bilateralSort(arr,startIndex,pivotIndex-1);
        bilateralSort(arr,pivotIndex+1,endIndex);
    }

    /**
     * 分治，双边循环法
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] arr,int startIndex,int endIndex){
        //取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right){
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot){
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot){
                left++;
            }

            //交换left和right指针所指向的元素
            if (left < right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
            System.out.println("right=【"+right+"】left=【"+left+"】partition111==="+Arrays.toString(arr));
        }

        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        System.out.println("partition222==="+Arrays.toString(arr));

        return left;
    }

    /**
     * 双边排序
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {4,4,6,5,3,2,8,1};
        bilateralSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
