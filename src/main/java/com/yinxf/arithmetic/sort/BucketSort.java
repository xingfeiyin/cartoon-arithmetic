package com.yinxf.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] array = {4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sorted = sort(array);
        System.out.println(Arrays.toString(sorted));
    }

    private static double[] sort(double[] array) {
        //得到数组的最大值和最小值，并算出差值d
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }

        double d = max - min;

        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i]-min) * (bucketNum-1) / d);
            bucketList.get(num).add(array[i]);
        }
        //对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            //JDK底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }

        //输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list:bucketList) {
            for (double ele: list) {
                sortedArray[index] = ele;
                index++;
            }
        }
        return sortedArray;
    }

}
