package com.yygx.algostruct.binarySearch;

import java.util.Random;

/**
 * <p>
 * 注释：二分查找
 * </p>
 * Since: 2024/9/28 <p>
 * Author: <a href="https://github.com/YFBY-Java" target="_blank">吟风抱月</a>
 */
public class BinarySearch {

    public static void main(String[] args) {
        int i = 0;
        int j = Integer.MAX_VALUE - 1;
        int middle = (i + j) / 2;   // 这里计算出的 middle 已经很大了
        System.out.println(middle);
        i = middle + 1;
        middle = (i + j) / 2;   // middle 再加上 j，超出int正整数的最大值了,变负了 （Java中第一位基本为符号位）
        System.out.println(middle);
    }


    /**
     * 二分查找基础版
     *
     * @param array  待查找的升序数组
     * @param target 待查找的目标值
     * @return <p>
     * 找到返回索引<p>
     * 找不到返回-1 <p>
     */
    public static int binarySearchBasic(int[] array, int target) {
        /*
         * 问题1: 为什么是 i<=j 而不是 i<j     —————— i=j时的值，也可能是要查找的值
         * 问题2: (i+j)/2 有没有问题？
         * */
        int i = 0, j = array.length - 1;  // 设置前后指针
        while (i <= j) {  // i<=j 表示还有没被查找的元素
            int middle = (i + j) >>> 1;  //   / 除法，向下取整，使用 >>> 无符号右移运算符
            if (target < array[middle]) {   // 目标小于中间值
                j = middle - 1;
            } else if (array[middle] < target) {  // 目标大于中间值
                i = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    public static int binarySearchAlternative(int[] array, int target) {
        int i = 0, j = array.length;   // 这种方式的j，只是作为一个边界，一定不是查找目标  因为最后一个索引是 length-1
        // 假设比较L次
        while (i < j) {
            int middle = (i + j) >>> 1;
            // 如果元素在最左边，那么会比较L次
            if (target < array[middle]) {
                j = middle;
            } else if (array[middle] < target) {  //如果元素在最右边，会比较2L次
                i = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }


    /**
     * 二分查找平衡版，减少平均比较次数
     * <ol>
     *     <li>左闭右开的区间，i指向的可能是目标，而j指向的不是目标</li>
     *     <li>不在循环内找出，等范围内只剩i时，退出循环，在循环外比较 a[i] 与 target</li>
     *     <li>循环内的平均比较次数减少了</li>
     *     <li>时间复杂度 O(log(n))</li>
     * </ol>
     *
     * @param array
     * @param target
     * @return
     */
    public static int binarySearchBalance(int[] array, int target) {
        int i = 0;
        int j = array.length;
        while (1 < j - i) {
            int middle = (i+j) >>> 1 ;
            if(target < array[middle]){  // 循环内的三分支减少为二分支，减少了平均比较次数，但是增大了最低比较次数
                j = middle;
            }else {
                i = middle;
            }
        }
        if(array[i] == target){
            return i;
        }else {
            return -1;
        }
    }

    /**
     * 二分查找返回插入点版 <p>
     *
     * @param array
     * @param target
     * @return 返回 插入这个元素应该是第几个元素 <p></p>
     * 用负值减1是为了避免-0 （Java中 0 == -0）
     */
    public static int binarySearchPoint(int[] array , int target){
        int i = 0,j = array.length;
        while (1 < j-i){
            int middle = (i+j) >>> 1;
            if(target < array[middle]){
                j = middle;
            }else {
                i = middle;
            }
        }
        if(array[i] == target){
            return i;
        }else {
            return -(i+1);  // 返回的值是负的插入点（即如果这个元素存在的话，它是第几个元素）
        }
    }

}
