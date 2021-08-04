package com.yinxf.arithmetic.interview;

import java.util.Stack;

/**
 * 用两个栈实现队列的功能
 *  用栈来模拟一个队列，要求实现队列的两个基本操作：入队、出队
 *  此方法的入队、出队时间复杂度都是O(1)，
 *  出队设计迁移复杂度是O(n),不涉及迁移复杂度为O(1)，这里有一个新概念，叫做均摊时间复杂度。
 *  需要元素迁移的出队操作只有少数情况，并且不可能连续出现，其后的大多数出队操作都不需要元素迁移。
 *  所以把时间均摊到每一次出队操作上，其时间复杂度为O(1)。
 */
public class StackQueue {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队操作
     * @param value
     */
    public void enQueue(Integer value){
        stackA.push(value);
    }

    /**
     * 出队操作
     * @return
     */
    public Integer deQueue(){
        //B不为空，直接出栈
        if (!stackB.isEmpty()){
            return stackB.pop();
        }
        //B为空，A也为空时，直接返回空
        if (stackA.isEmpty()){
            return null;
        }
        //A不为空时，把A中的元素出栈，入栈到B中
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }

        //返回B中的栈顶元素
        return stackB.pop();
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }
}
