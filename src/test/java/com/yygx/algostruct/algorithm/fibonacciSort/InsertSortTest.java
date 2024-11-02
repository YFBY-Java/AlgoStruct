package com.yygx.algostruct.algorithm.fibonacciSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertSortTest {

    @Test
    void testSort() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = {3, 2, 4, 1, 5};
        InsertSort.sort(actual);
        Assertions.assertArrayEquals(expected,actual);
        actual = new int[]{5,4,3,2,1};
        InsertSort.sort(actual);
        Assertions.assertArrayEquals(expected,actual);
        actual = new int[]{1,1,1,1,1};
        InsertSort.sort(actual);
    }
}
