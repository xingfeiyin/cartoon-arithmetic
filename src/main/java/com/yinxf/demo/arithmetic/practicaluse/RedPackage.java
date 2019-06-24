package com.yinxf.demo.arithmetic.practicaluse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 如何实现红包算法
 * 规则：
 * 1.所有人抢到的金额之和要等于红包金额，不能多也不能少
 * 2.每个人至少抢到1分钱
 * 3.要保证红包拆分的金额尽可能分布均衡，不要出现两极分化太严重的情况。
 */
public class RedPackage {

    /**
     * 方法一：二倍均值法
     * 假设剩余红包金额为m元，剩余人数为n，那么有如下公式：
     *      每次抢到的金额 = 随机区间[0.01 , m/n * 2 -0.01]元
     * 这个公式保证了每次随机金额的平均值是相等的。
     *
     * 这种方法虽然公平，但也存在局限性，即除最后一次外，其他每次抢到的金额都要小于剩余人均金额的2倍，
     *      并不是完全自由地随机抢红包。
     */

    /**
     * 拆分红包
     * @param totalAmount 总金额(以分为单位)
     * @param totalPeopleNum 总人数
     * @return
     */
    public static List<Integer> divideRedPackage(Integer totalAmount,Integer totalPeopleNum){
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            //随机范围：[1,剩余人均金额的2倍 - 1]分
            int amount = random.nextInt(restAmount/restPeopleNum * 2 - 2) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPackage(1000,10);
        for (Integer amount : amountList) {
            System.out.println("抢到金额："+new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }


    /**
     * 方法二：线段切割法
     *
     */

}
