package com.yinxf.demo.arithmetic.interview;

import java.util.Arrays;

/**
 * 寻找全排列的下一个数
 * 题目：给出一个正整数，找出这个正整数所有数字全排列的下一个数。说通俗点就是在一个整数所包含数字的
 *      全部组合中，找到一个大于且仅大于原数的新整数。
 *      如输入12345，则返回12354；如输入12354，则返回12435，如输入12435，则返回12453
 *
 * 字典序算法
 * 时间复杂度为O(n)
 */
public class FindNearestNumber {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        //打印12345之后的10个全排列整数
        for (int i = 0; i < 10; i++) {
            numbers = findNearestNumber(numbers);
            outputNumbers(numbers);
        }
    }

    private static void outputNumbers(int[] numbers) {
        for (int i :numbers ) {
            System.out.print(i);
        }
        System.out.println();
    }

    /**
     * 1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
     * 2.让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置。
     * 3.把原来的逆序区域转为顺序状态。
     * @param numbers
     * @return
     */
    private static int[] findNearestNumber(int[] numbers) {
        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbers);

        //如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回null
        if (index == 0){
            return null;
        }

        //2.让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置。
        //复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers,numbers.length);
        exchangeHead(numbersCopy,index);

        //3.把原来的逆序区域转为顺序状态。
        reverse(numbersCopy,index);

        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbers){
        for (int i = numbers.length-1; i > 0 ; i--) {
            if (numbers[i] > numbers[i-1]){
                return i;
            }
        }
        return 0;
    }

    private static int[] reverse(int[] num, int index) {
        for (int i = index,j=num.length-1; i < j; i++,j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    private static int[] exchangeHead(int[] numbersCopy, int index) {
        int head = numbersCopy[index-1];
        for (int i = numbersCopy.length-1; i > 0 ; i--) {
            if (head < numbersCopy[i]){
                numbersCopy[index-1] = numbersCopy[i];
                numbersCopy[i] = head;
                break;
            }
        }
        return numbersCopy;
    }
}
