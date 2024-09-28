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
        * */
        int i = 0, j = array.length - 1;  // 设置前后指针
        while (i <= j) {  // i<=j 表示还有没被查找的元素
            int middle = (i + j) / 2;  //   / 除法，向下取整
            if (target < array[middle]) {   // 目标小于中间值
                j = middle - 1;
            } else if (target > array[middle]) {  // 目标大于中间值
                i = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

}
