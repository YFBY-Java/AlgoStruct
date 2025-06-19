package com.yygx.algostruct;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.yygx.algostruct.algorithm.binarySearch.BinarySearch.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>
 * 注释：二分查找测试类
 * </p>
 * Since: 2024/9/28 <p>
 * Author: <a href="https://github.com/YFBY-Java" target="_blank">吟风抱月</a>
 */
public class TestBinarySearch {

    @Test
    @DisplayName("binarySearchBasic 找到")
    public void test1(){
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBasic(a, 7));
        assertEquals(1, binarySearchBasic(a, 13));
        assertEquals(2, binarySearchBasic(a, 21));
        assertEquals(3, binarySearchBasic(a, 30));
        assertEquals(4, binarySearchBasic(a, 38));
        assertEquals(5, binarySearchBasic(a, 44));
        assertEquals(6, binarySearchBasic(a, 52));
        assertEquals(7, binarySearchBasic(a, 53));

        assertEquals(-1, binarySearchBasic(a, 0));
        assertEquals(-1, binarySearchBasic(a, 15));
        assertEquals(-1, binarySearchBasic(a, 60));
    }

    @Test
    @DisplayName("测试BinarySearchLeftmost 返回-1")
    public void testBinarySearchLeftmost(){
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchLeftmost(a, 1));
        assertEquals(1, binarySearchLeftmost(a, 2));
        assertEquals(2, binarySearchLeftmost(a, 4));
        assertEquals(5, binarySearchLeftmost(a, 5));
        assertEquals(6, binarySearchLeftmost(a, 6));
        assertEquals(7, binarySearchLeftmost(a, 7));

        assertEquals(-1, binarySearchLeftmost(a, 0));
        assertEquals(-1, binarySearchLeftmost(a, 3));
        assertEquals(-1, binarySearchLeftmost(a, 8));
    }

    @Test
    @DisplayName("测试BinarySearchRightmost 返回-1")
    public void testBinarySearchRightmost(){
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchRightmost(a, 1));
        assertEquals(1, binarySearchRightmost (a, 2));
        assertEquals(4, binarySearchRightmost (a, 4));
        assertEquals(5, binarySearchRightmost (a, 5));
        assertEquals(6, binarySearchRightmost (a, 6));
        assertEquals(7, binarySearchRightmost (a, 7));

        assertEquals(-1, binarySearchRightmost(a, 0));
        assertEquals(-1, binarySearchRightmost(a, 3));
        assertEquals(-1, binarySearchRightmost(a, 8));
    }

    // 测试
}
