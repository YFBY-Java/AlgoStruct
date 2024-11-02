package com.yygx.algostruct.algorithm.fibonacciSort;


/**
 * 斐波那契冒泡
 */
public class FibonacciBubble {


    public static void sort(int[] array){
        bubble(array,array.length-1);
    }


    /**
     *
     * @param array
     * @param right 未排序区域右边界
     */
    private static void bubble(int[] array,int right){
        if(right == 0) return;
        int isExchanged = 0;
        for (int i = 0; i < right; i++) {
            if(array[i] > array[i+1]){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
            isExchanged = i;
        }
        bubble(array,isExchanged);   // 如果没发生交换，说明已经排完序了，会直接返回
    }



}