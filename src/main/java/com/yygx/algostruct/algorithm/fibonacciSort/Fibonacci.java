package com.yygx.algostruct.algorithm.fibonacciSort;


/**
 * 斐波那契数列
 * <p>
 *     斐波那契数列：从第三个元素开始，每个元素等于前两项之和
 * </p>
 */
public class Fibonacci {

    // 单路递归：每次递归是，只包含一次对自身的调用
    // 多路递归：每次递归时，包含多次对自身的调用


    /**
     * 时间复杂度：2*f(n+1)-1
     * <p>
     *     即 1.618^n
     * </p>
     * @param n
     * @return
     */
    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

}