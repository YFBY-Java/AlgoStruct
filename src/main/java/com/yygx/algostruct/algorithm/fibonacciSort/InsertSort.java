package com.yygx.algostruct.algorithm.fibonacciSort;

public class InsertSort {

    public static void sort(int[] array) {
        insertSort(array, 1);
    }

    private static void insertSort(int[] array, int low) {
        if (low == array.length) return;
        int temp = array[low];
        int isSorted = low - 1;   // 已排序区指针,该指针右边的部分已比较过
        while (isSorted >= 0 && array[isSorted] > temp) {   // 没有找到插入位置
            array[isSorted + 1] = array[isSorted];   // 空出插入位置
            isSorted--;
        }
        array[isSorted + 1] = temp;
        // 找到插入位置
        insertSort(array, low + 1);
    }
}