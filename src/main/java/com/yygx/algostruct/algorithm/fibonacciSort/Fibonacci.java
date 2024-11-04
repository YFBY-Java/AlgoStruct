package com.yygx.algostruct.algorithm.fibonacciSort;



import java.util.Arrays;

/**
 * 斐波那契数列
 * <p>
 * 斐波那契数列：从第三个元素开始，每个元素等于前两项之和
 * </p>
 */
public class Fibonacci {

    // 单路递归：每次递归是，只包含一次对自身的调用
    // 多路递归：每次递归时，包含多次对自身的调用


    /**
     * 时间复杂度：2*f(n+1)-1
     * <p>
     * 即 1.618^n
     * </p>
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    /**
     * 递归剪枝
     *
     * @param n
     * @return
     */
    public static int recursivePruning(int n) {
        int[] pruning = new int[n + 1];
        Arrays.fill(pruning, Integer.MIN_VALUE);
        pruning[0] = 0;
        pruning[1] = 1;   // 0 1 1 2 3 5
        return fibonacci(n,pruning);
    }

    private static int fibonacci(int n, int[] pruning) {
        if(pruning[n] != Integer.MIN_VALUE) return pruning[n];
        int x = fibonacci(n - 1, pruning);
        int y = fibonacci(n - 2, pruning);
        pruning[n] = x + y;
        return pruning[n];
    }


    public static long stackFlow(long n){
        if(n == 1) return 1;
        return stackFlow(n-1) + n;
    }


    public static void main(String[] args) {
        // 计算耗时
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start("剪枝");
//        System.out.println(recursivePruning(40));
//        stopWatch.stop();
//
//        stopWatch.start("递归");
//        System.out.println(fibonacci(40));
//        stopWatch.stop();
//        System.out.println(stopWatch.prettyPrint());

        System.out.println(stackFlow(15000));
    }




}