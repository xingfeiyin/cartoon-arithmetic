package com.yinxf.demo.arithmetic.interview;

/**
 * 如何判断一个数是否为2的整数次幂
 *
 * 给你一个正整数，如何判断它是不是2的整数次幂？
 */
public class PowerOf2 {

    public static void main(String[] args) {
        System.out.println(isPowerOf(32));
        System.out.println(isPowerOf(19));
    }

    /**
     * 2的整数次幂，转换成二进制时，只有最高位是1，其他位都是0
     * 2的整数次幂减1，它的二进制数字全部变成了1。
     * 所以凡是2的整数次幂和它本身减1的结果进行与运算，结果都必定是0.
     *
     * @param num
     * @return
     */
    private static boolean isPowerOf(int num) {
        return (num & (num-1)) == 0;
    }
}
