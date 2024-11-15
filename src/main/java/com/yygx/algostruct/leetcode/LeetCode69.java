package com.yygx.algostruct.leetcode;


/**
 * 力扣69.x的平方根
 * <p>
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * </p>
 */
public class LeetCode69 {


    /**
     * 暴力搜索
     *
     * @param x
     * @return
     */
    public int mySqrtFor(int x) {
        for (int i = 0; i <= x; i++) {
            if (i * i == x) {
                return i;
            } else if (i * i > x) {
                return i - 1;
            }
        }
        return 0;
    }


    /**
     * 二分查找法
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int middle = ((right - left) >> 1) + left;
            long square = (long) middle * middle;
            if (square <= x) {
                ans = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return ans;
    }


    /**
     * 牛顿迭代
     *
     * @param x
     * @return
     */
    public int mySqrtIterate(int x) {
        if (x <= 1) return x;
        // 初始猜测是，选取 x 的一半作为初始值
        double guess = x / 2.0;
        // 设置精度控制，避免无线循环，防止精度误差
        double epsilon = 1e-6;
        // 进行牛顿迭代，直到误差小于指定精度
        while (Math.abs(guess * guess - x) > epsilon) {
            guess = (guess + x / guess) / 2;
        }
        return (int) guess;
    }


    /**
     * 袖珍计算器法
     *
     * @param x
     * @return
     */
    public int mySqrtCalculator(int x) {
        if (x == 0) return 0;
        // exp ： 返回 e 的 x 次方
        // log ： 返回 ln(x)    ln(x) = log e (x)
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }


    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        int x = 8;
        int result = leetCode69.mySqrt(x);
        System.out.println(result);
        int x1 = 2147395599;
        int result1 = leetCode69.mySqrt(x1);
        System.out.println(result1);

        System.out.println("暴力搜索");
        int x2 = 2147395599;
        int result2 = leetCode69.mySqrtFor(x2);
        System.out.println(result2);
        System.out.println("牛顿迭代");
        int x3 = 2147395599;
        int result3 = leetCode69.mySqrtIterate(x3);
        System.out.println(result3);


        System.out.println("袖珍计算器法");
        int x4 = 2147395599;
        int result4 = leetCode69.mySqrtCalculator(x4);
        System.out.println(result4);
    }

}