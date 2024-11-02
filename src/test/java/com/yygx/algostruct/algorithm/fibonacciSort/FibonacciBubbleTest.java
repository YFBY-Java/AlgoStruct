package com.yygx.algostruct.algorithm.fibonacciSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FibonacciBubbleTest {

    @Test
    @DisplayName("测试递归冒泡")
    void testSort() {
        int [] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {5,4,3,2,1};
        FibonacciBubble.sort(arr1);
        Assertions.assertArrayEquals(arr, arr1);

        int[] arr2 = {4,5,3,2,1};
        FibonacciBubble.sort(arr2);
        Assertions.assertArrayEquals(arr, arr2);

    }
}
