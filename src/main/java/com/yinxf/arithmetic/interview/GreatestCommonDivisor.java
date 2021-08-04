package com.yinxf.arithmetic.interview;

/**
 * 求两个数的最大公约数
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor1(25, 5));
        System.out.println(getGreatestCommonDivisor1(100, 80));
        System.out.println(getGreatestCommonDivisor1(27, 14));

        System.out.println("--------------------------------");
        System.out.println(getGreatestCommonDivisor2(25, 5));
        System.out.println(getGreatestCommonDivisor2(100, 80));
        System.out.println(getGreatestCommonDivisor2(27, 14));


        System.out.println("--------------------------------");
        System.out.println(getGreatestCommonDivisor3(25, 5));
        System.out.println(getGreatestCommonDivisor3(100, 80));
        System.out.println(getGreatestCommonDivisor3(27, 14));

        System.out.println("--------------------------------");
        System.out.println(gcd(25, 5));
        System.out.println(gcd(100, 80));
        System.out.println(gcd(27, 14));
    }

    /**
     * 方法一：暴力枚举法
     * 从较小整数的一半开始，试图找到一个合适的整数i,看看这个整数能否被a和b同时整除。
     *
     * 缺点：效率不行，如果传入的是10000和10001，需要循环10000/2-1=4999次
     *
     * 时间复杂度为O(min(a,b))
     * @param a
     * @param b
     * @return
     */
    private static int getGreatestCommonDivisor1(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        for (int i = small / 2; i > 1; i--) {
            if (small % i == 0 && big % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 方法二：辗转相除法:两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
     * <p>
     * 计算a除以b的余数c，把问题转化成求b和c的最大公约数；
     * 然后计算b除以c的余数d,把问题转换成求c和d的最大公约数；
     * 再计算出c除以d的余数e,把问题转化成d和e的最大公约数
     *
     * 缺点：当两个整数较大时，做a%b取模运算的性能会比较差
     *
     * 时间复杂度可近似为O(log(max(a,b)))，但是取模性能较差
     * @param a
     * @param b
     * @return
     */
    private static int getGreatestCommonDivisor2(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisor2(big % small , small);
    }

    /**
     * 方法三：更相减损术：两个正整数a和b（a>b）,它们的最大公约数等于a-b的差值c和较小数b的最大公约数。
     *
     * 计算出a和b的差值c(假设a>b) ,把问题转化成求b和c的最大公约数，
     * 然后计算出c和b的差值d(假设c>b),把问题转化成求b和d的最大公约数
     * 再计算出b和d的差值e(假设b>d),把问题转化成求d和e的最大公约数
     *
     * 缺点：更相减损术是不稳定的算法，当两个数相差悬殊时，如计算10000和1的最大公约数，要递归9999次。
     *
     * 避免取模运算，算法性能不稳定，最坏时间复杂度为O(max(a,b))
     * @param a
     * @param b
     * @return
     */
    private static int getGreatestCommonDivisor3(int a, int b) {
        if (a == b){
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getGreatestCommonDivisor3(big - small , small);
    }

    /**
     * 方法四：把辗转相除法和更相减损术的优势结合起来，在更相减损术的基础上使用移位运算。
     *
     * 当a和b均为偶数时，gcd(a,b)=2*gcb(a/2,b/2)=2*gcd(a>>1,b>>1).
     * 当a为偶数，b为奇数时，gcd(a,b)=gcd(a/2,b)=gcd(a>>1,b).
     * 当a为奇数，b为偶数时，gcd(a,b)=gcd(a,b/2)=gcd(a,b>>1).
     * 当a和b均为奇数时，先利用更相减损术运算一次，gcd(a,b)=gcd(b,a-b),此时a-b必然是偶数，
     *      然后再可以进行移位运算
     *
     * 避免取模运算，算法性能稳定，时间复杂度为O(log(max(a,b)))
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        if (a == b){
            return a;
        }
        if ((a&1) == 0 && (b&1) == 0){
            return gcd(a>>1,b>>1)<<1;
        }else if ((a&1) == 0 && (b&1) != 0){
            return gcd(a>>1,b);
        }else if ((a&1) != 0 && (b&1) == 0){
            return gcd(a,b>>1);
        }else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return gcd(big-small,small);
        }
    }
}
