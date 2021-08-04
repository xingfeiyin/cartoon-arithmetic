package com.yinxf.arithmetic.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找缺失的整数
 */
public class FindMissInteger {
    /**
     * 题目1：在一个无须数组里有99个不重复的正整数，范围是1~100，唯独缺少1个1~100中的整数。
     *      如何找出这个缺失的整数？
     * 解法一：
     *      1.创建一个哈希表，以1到100这100个整数为key，然后遍历整个数组，每读到一个整数，
     *      就定位到哈希表中对应的key，然后删除这个key。
     *      2.由于数组中缺少一个整数，哈希表最终会有99个key被删除，从而剩下一个唯一的key，
     *      这个剩下的key就是那个缺失的整数。
     *      3.假设数组长度是n，该解法的时间复杂度是O(1),空间复杂度是O(n)。
     *      此方法时间最优，但额外开辟了内存空间，有没有办法降低空间复杂度？解法二
     *
     * 解法二：
     *      1.先把数组元素从小到大进行排序，然后遍历已经有序的数组，如果发现某两个相邻元素
     *      并不连续，说明缺失的就是这两个元素之间的整数。
     *      2.假设数组长度是n，如果用时间复杂度为O(nlogn)的排序算法进行排序，那么该解法的
     *      时间复杂度为O(nlogn)，空间复杂度为O(1)
     *      这个解法没有开辟额外的内存空间，但时间复杂度又太大了，有没有办法对时间复杂度和
     *      空间复杂度进行优化？解法三
     *
     * 解法三：先求出1+2+3+……+100的和，然后依次减去数组里的元素，最后得到的差值就是缺失的整数
     *      没有重复元素的数组中，次解法在时间和空间上已经最优了。
     *
     */
    public static void main(String[] args) {
        int[] array = {1,2,7,3,5,4,10,9,8};
        System.out.println("缺失是值为："+getMissInteger(array));
        System.out.println("------------------");

        //问题扩展一
        int[] arr = {1,4,7,9,5,4,7,9,1};
        System.out.println("奇数次的整数为:"+getMissIntegerV1(arr));
        System.out.println("------------------");

        //问题扩展二
        int[] array2 = {4,1,2,2,5,1,4,3};
        int[] result = getMissIntegerV2(array2);
        System.out.println("两个奇数次整数为："+result[0] +"," + result[1]);


    }
    private static int getMissInteger(int[] array){
        int missValue = 0 ;
        //解法一
        HashMap<Integer,String> map = new HashMap<Integer,String>(10);
        for (int i = 1; i <= 10; i++) {
            map.put(i,"");
        }
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.remove(array[i]);
            }
        }

        for (Integer key : map.keySet()) {
            System.out.println("解法一：key="+key);
            missValue = key;
        }

        //解法二
        Arrays.sort(array);
        for (int i = array.length-1; i > 0; i--) {
            int temp = array[i] - array[i-1];
            if (temp != 1){
                missValue = array[i] - 1;
                break;
            }
        }
        System.out.println("解法二key="+missValue);

        //解法三
        int sum = 0;
        for (int i = 1; i <= 10 ; i++) {
            sum += i;
        }
        for (int i = 0; i < array.length; i++) {
            sum -= array[i];
        }
        missValue = sum;
        System.out.println("解法三key="+missValue);

        return missValue;
    }

    /**
     * 问题扩展一
     * 一个无序数组里有若干个正整数，范围是1~100，其中99个整数都出现了偶数次，
     * 是有一个整数出现了奇数次，如何找到这个出现奇数次的整数？
     * 异或算法：在进行位运算时，相同位得0，不同位得1。
     *      1010111
     *  xor 1101100
     *  ------------
     *      0111011
     *
     * 解法：遍历整个数组，依次做异或运算，由于异或运算在进行位运算时，相同为0，不同为1，
     *      因此出现偶数次的整数都会相互抵消变成0，只有唯一出现奇数次的整数会被留下。
     */

    private static int getMissIntegerV1(int array[]){
        int  missValue = array[0];
        for (int i = 1; i < array.length; i++) {
            missValue ^= array[i];
        }
        System.out.println("奇数次整数为："+missValue);
        return missValue;
    }

    /**
     * 问题扩展二
     * 假设一个无序数组里有若干个正整数，范围是1~100，其中有98个整数出现了偶数次，
     * 只有两个整数出现了奇数次，如何找到这两个出现奇数次的整数？
     *
     * 解法：分治法
     * 把2个出现奇数次的整数命名为A和B，遍历整个数组，然后依次做疑惑运算，进行异或运算的
     * 最终结果，等同于A和B进行异或运算的结果，在这个结果中，至少会有一个二进制位是1.
     * 举例：数组{4,1,2,2,5,1,4,3}，所以元素进行异或运算的结果是00000110B。
     *      选定结果中值为1的某一位数字，如00000110B的倒数第2位是1，这说明A和B对应的
     *      二进制的倒数第2位是不同的，其中必定有一个整数的倒数第2位是0，另一个倒数第2位
     *      是1。
     * 根据这个结论，把原数组按照二进制的倒数第2位的不同，分成两部分，一部分倒数第2位是0，
     *      另一部分倒数第2位是1，由于A和B的倒数第2位不同，所以A、B被分别分到两部分中，绝对不会
     *      出现A和B在同一部分的情况，另一部分即没有A也没有B的情况。
     *
     * 这样问题又可以按照原先的异或运算法，从每一部分找出唯一的奇数次整数即可。
     *
     * 假设数组长度是n，那么该解法的时间 复杂度是O(n)，数组分成两部分，不需要借助额外的存
     *      储空间，完全可以在按二进制位分组的同时来做异或运算，所空间复杂度为O(1)
     */

    private static int[] getMissIntegerV2(int[] array){
        //用于存储两个出现奇数次的整数
        int[] result = new int[2];
        //第一次进行整体异或运算
        int xorResult = 0;
        for (int i = 0; i < array.length; i++) {
            xorResult ^= array[i];
        }
        //如果进行异或运算的结果为0，则输入的数组不符合题目要求
        if (xorResult == 0){
            return null;
        }

        //确定2个整数的不同位，以此来做分组
        int separator = 1;
        while (0 == (xorResult&separator)){
            separator <<= 1;
        }

        //第二次分组进行异或运算
        for (int i = 0; i < array.length; i++) {
            if (0 == (array[i]&separator)){
                result[0] ^= array[i];
            }else {
                result[1] ^= array[i];
            }
        }

        return result;
    }



}
