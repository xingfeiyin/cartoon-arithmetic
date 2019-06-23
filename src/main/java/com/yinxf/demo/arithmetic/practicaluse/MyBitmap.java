package com.yinxf.demo.arithmetic.practicaluse;

/**
 * Bitmap的巧用
 * 为了精准定位用户群体，实现用于信息的标签化，用户标签包括社会属性、生活习惯、消费行为等。
 *      通过标签可以对用户群体进行统计，如统计用户男女比例、统计喜欢旅游的用户量等。
 * 使用Bitmap算法，又叫位图算法，表示内存中连续的二进制位(bit)所组成的数据结构，
 *      该算法主要用于对大量整数做去重和查询操作。
 * 解法：不用一个用户对应多个标签，而是一个标签对应多个用户。信息不一定非要以用户为中心，
 *      也能以标签为中心来进行存储，让每一个标签存储包含此标签的所有用户ID，就像倒索引一样。
 *      
 * bitmap做交集和并集运算也有极大的便利。bitmap高性能的位运算。
 * 
 * 如何利用bitmap实现反向匹配？
 *      可以借助一个全量的bitmap，使用异或运算进行操作，即相同位为0，不同位为1。
 * 
 */
public class MyBitmap {
    //每一个Word是一个long类型元素，对应一个64位二进制数据
    private long[] words;
    //bitmap的位数大小
    private int size ;

    public MyBitmap(int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size-1) + 1)];
    }

    /**
     * 定位bitmap某一位所对应的Word
     * @param bitIndex 位图的第bitIndex位(bitIndex=0代表bitmap左数第一位)
     * @return
     */
    private int getWordIndex(int bitIndex) {
        //右移6位，相当于除以64
        return bitIndex >> 6;
    }

    /**
     * 判断bitmap某一位的状态
     * @param bitIndex 位图的第bitIndex位(bitIndex=0代表bitmap左边第一位)
     * @return
     */
    private boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size -1){
            throw new IndexOutOfBoundsException("超过bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 把bitmap某一位设置为true
     * @param bitIndex 位图的第bitIndex位(bitIndex=0代表bitmap左数第一位)
     */
    private void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1){
            throw new IndexOutOfBoundsException("超过bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    public static void main(String[] args) {
        MyBitmap bitmap = new MyBitmap(128);
        bitmap.setBit(126);
        bitmap.setBit(75);
        System.out.println(bitmap.getBit(126));
        System.out.println(bitmap.getBit(75));
    }
}
