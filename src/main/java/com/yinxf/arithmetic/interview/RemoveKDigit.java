package com.yinxf.arithmetic.interview;

/**
 * 删除k个数字后的最小值
 * 题目：给出一个整数，从该整数中去掉k个数字，要求剩下的数字形成的新整数尽可能小，
 *      应该如何选取被去掉的数字？
 * 依次求得局部最优解，最终得到全部最优解的思想叫做贪心算法。
 * String中的subString方法的底层实现，涉及新字符串的创建，以及逐个字符的复制。
 *
 */
public class RemoveKDigit {
    public static void main(String[] args) {
        System.out.println(remove("1593212",3));
        System.out.println(remove("30200",1));
        System.out.println(remove("10",2));
        System.out.println(remove("541270936",3));
    }

    private static String remove(String num, int k) {
        //新整数的最终长度 = 原整数长度 - 1
        int newLength = num.length() - k;
        //创建一个栈，用于接收所有的数字
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字时，栈顶数字出栈，相当于删除数字
            while (top > 0 && stack[top-1] > c && k > 0){
                top -= 1;
                k -= 1;
            }
            //遍历到的当前数字入栈
            stack[top++] = c;
        }
        //找到栈中第一个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset < newLength && stack[offset] == '0'){
            offset++;
        }
        return offset == newLength ? "0" : new String(stack,offset,newLength-offset);
    }


}
