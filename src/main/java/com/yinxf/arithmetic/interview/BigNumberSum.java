package com.yinxf.arithmetic.interview;

/**
 * 如何实现大整数相加
 * 题目：给出两个很大的整数，要求实现程序求出两个整数之和
 */
public class BigNumberSum {

    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318","95481253129"));
        System.out.println(bigNumberSum("15","300"));
    }

    private static String bigNumberSum(String numberA, String numberB) {
        //把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int lengthA = numberA.length();
        int lengthB = numberB.length();
        int maxLength = lengthA > lengthB ? lengthA : lengthB;

        int[] arrA = new int[maxLength+1];
        for (int i = 0; i < lengthA ; i++) {
            arrA[i] = numberA.charAt(lengthA-1-i)-'0';
        }

        int[] arrB = new int[maxLength+1];
        for (int i = 0; i < lengthB; i++) {
            arrB[i] = numberB.charAt(lengthB-1-i)-'0';
        }

        int[] result = new int[maxLength+1];
        for (int i = 0; i < result.length ; i++) {
            int temp = result[i];
            temp += arrA[i];
            temp += arrB[i];
            if (temp >= 10){
                temp = temp - 10;
                result[i+1] = 1;
            }
            result[i] = temp ;
        }

        //把result数组逆序转成string
        StringBuilder sb = new StringBuilder();
        boolean findFirst = false;
        for (int i = result.length - 1; i > 0 ; i--) {
            if (!findFirst){
                if (result[i] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
