package com.yinxf.demo.arithmetic.interview;

/**
 * 1.判断链表是否有环
 * 创建两个指针p1和p2，让他们同时指向链表的头节点，然后开始一个大循环，在循环体中，
 * 让指针p1每次向后移动一个节点，让p2每次向后移动两个节点，然后判断两个指针指向的节点费否相同。
 * 如果相同，则可以判断出链表有环，如果不同，则继续下一次循环。
 */
public class JudgeCycle {

    /**
     * 判断是否有环
     * @param head
     * @return
     */
    public static boolean isCycle(Node head){
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断还的长度大小
     * @param head
     * @return
     */
    public static int cycleSize(Node head){
        Node p1 = head;
        Node p2 = head;
        int  size = 0;
        int size2 = 0;
        boolean flag = true;
        while (p2 != null && p2.next != null){
            size++;
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                if (flag){
                    size2 = size;
                    flag = false;
                    continue;
                }
                if (!flag){
                    size2 = size-size2;
                    break;
                }
            }
        }
        return size2;
    }

    /**
     * 判断环的入环点
     * @param head
     * @return
     */
    public static Node fisrtNode(Node head){
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                p1 = head;
                while (true){
                    p1 = p1.next;
                    p2 = p2.next;
                    if (p1 == p2){
                        return p1;
                    }
                }
            }
        }
        return null;
    }

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;
        System.out.println("判断是否有环："+isCycle(node1));
        System.out.println("判断环的长度(大小)："+cycleSize(node1));
        System.out.println("判断环的入环点是："+fisrtNode(node1).data);
    }
}
