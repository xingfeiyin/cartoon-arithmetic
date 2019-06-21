package com.yinxf.demo.arithmetic.interview;

import java.util.Stack;

/**
 * 最小栈的实现
 * 1.设原栈A，此时再创建一个栈B，作为A的辅助栈
 * 2.当第一个元素进入栈A时，也进入栈B，这时唯一的元素是栈A的当前最小值。
 * 3.之后每当新元素进入栈A时，比较新元素和当前栈A的最小值的大小，
 *      如果小于栈A当前最小值，则让新元素进入栈B，此时栈B的栈顶元素就是栈A当前最小值。
 * 4.每当栈A有元素出栈时，如果出栈元素是栈A当前最小值，则让栈B的栈顶元素也出栈。
 *      此时栈B余下的栈顶元素所指向的，是栈A当中原本第二小的元素，代替刚才出栈的元素
 *      成为栈A的当前最小值
 * 5.当调用getMin方法时，返回栈B的栈顶所存储的值，这也是栈A的最小值。
 *
 * 进栈、出栈、取最小值的时间复杂度都是O(1)，最坏情况空间复杂度是O(n)
 */
public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈操作
     * @param element
     */
    public void push(int element){
        mainStack.push(element);
        //如果辅助栈为空，或者新元素小于等于辅助栈栈顶，则将新元素压入辅助栈
        if (minStack.isEmpty() || element <= minStack.peek()){
            minStack.push(element);
        }
    }

    /**
     * 出栈操作
     * @return
     */
    public Integer pop(){
        //如果出栈元素和辅助栈栈顶元素值相等，辅助栈出栈
        if (mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * 获取栈的最小元素
     * @return
     * @throws Exception
     */
    public int getMin() throws Exception{
        if (mainStack.empty()){
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
