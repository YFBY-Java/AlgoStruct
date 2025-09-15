package com.yygx.algostruct.written.xiaohongshu;


import java.util.Scanner;

/**
 * 判断一个数是否是“好数”
 * <br/>
 * 定义：如果一个数是正整数，并且它所有不同的质因数之和为奇数，则称它为“好数”。<br/>
 * 特殊情况：当 n = 1 时，没有质因数，其和视为 0，因此 1 不是好数。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：n = 12<br/>
 * 输出：true<br/>
 * 解释：12 的质因数是 2 和 3，不同质因数之和 = 2 + 3 = 5，为奇数，所以是好数。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：n = 18<br/>
 * 输出：false<br/>
 * 解释：18 的质因数是 2 和 3，不同质因数之和 = 2 + 3 = 5，为奇数，所以 18 是好数。<br/>
 * <br/>
 * 示例 3：<br/>
 * 输入：n = 1<br/>
 * 输出：false<br/>
 * 解释：没有质因数，总和为 0，不是奇数。<br/>
 */
public class GoodNumbers {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isGoodNumber(n) ? "YES" : "NO");
    }


    static boolean isGoodNumber(int n) {
        // 特殊情况：1 没有质因数，和视为 0 → 偶数，不是好数
        if (n == 1) return false;
        int sum = 0;       // 用来累加 n 的不同质因数
        int temp = n;      // 临时变量，用于分解质因数，避免修改原数 n
        // 处理质因数 2
        if (temp % 2 == 0) {   // 如果 temp 能被 2 整除，说明 2 是质因数
            sum += 2;          // 将 2 加入质因数和
            while (temp % 2 == 0) temp /= 2; // 去掉所有 2 的倍数，只保留一次质因数 2
        }
        // 处理大于 2 的质因数
        for (int i = 3; i * i <= temp; i += 2) {  // 遍历奇数，从 3 开始，步长为 2
            if (temp % i == 0) {                  // 如果 i 能整除 temp，说明 i 是质因数
                sum += i;                          // 将 i 加入质因数和
                while (temp % i == 0) temp /= i;  // 去掉 temp 中所有 i 的倍数，只加一次
            }
        }
        // 如果剩下的 temp > 1，说明它本身就是质数
        if (temp > 1) sum += temp;  // 将剩下的质数累加到 sum
        return sum % 2 == 1; // 判断质因数和是否为奇数，奇数返回 true（好数），偶数返回 false
    }





}