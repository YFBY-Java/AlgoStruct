package com.yygx.algostruct.LeetCodeHot100;


import org.junit.Test;

/**
 * LeetCode7.整数反转
 * <br/>
 * 给你一个 32 位的有符号整数 x，返回将 x 中的数字部分反转后的结果。<br/>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31, 2^31 − 1]，就返回 0。<br/>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：x = 123<br/>
 * 输出：321<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：x = -123<br/>
 * 输出：-321<br/>
 * <br/>
 * 示例 3：<br/>
 * 输入：x = 120<br/>
 * 输出：21<br/>
 * <br/>
 * 示例 4：<br/>
 * 输入：x = 0<br/>
 * 输出：0<br/>
 */
public class LeetCode7 {

    public int reverse(int x) {
        StringBuilder res = new StringBuilder();
        String strX = "";
        // 1.判断是否为负数
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x = -x;
        }
        strX = x + "";
        // 2.进行反转
        for (int i = strX.length() - 1; i >= 0; i--) {
            res.append(strX.charAt(i));
        }
        //  等同于以下代码：
        // StringBuilder res = new StringBuilder(strX).reverse();
        // 3. 反转返回的结果
        try{
            return positive ? Integer.parseInt(res.toString()) : -Integer.parseInt(res.toString());

        }catch (Exception e){
            return 0;
        }
    }


    @Test
    public void test() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
    }

}
