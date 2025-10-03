package com.yygx.algostruct.test;

import java.math.BigInteger;
import java.util.Random;

public class Test1 {


    // 生成指定长度的随机正整数字符串，首位不为 '0'
    private static String randomDigits(int length, Random rnd) {
        StringBuilder sb = new StringBuilder(length);
        // 首位 1-9
        sb.append((char) ('1' + rnd.nextInt(9)));
        for (int i = 1; i < length; i++) {
            sb.append((char) ('0' + rnd.nextInt(10)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Random rnd = new Random();

        // 1. 生成 15 位和 12 位数字字符串
        String aStr = randomDigits(15, rnd);
        String bStr = randomDigits(12, rnd);

        System.out.println("15 位数 a = " + aStr);
        System.out.println("12 位数 b = " + bStr);

        // 2. 将字符串解析为 BigInteger（解析不计入“仅乘法”计时）
        long tParseStart = System.nanoTime();
        BigInteger a = new BigInteger(aStr);
        BigInteger b = new BigInteger(bStr);
        long tParseEnd = System.nanoTime();

        // 3. 仅计时乘法操作
        long tMulStart = System.nanoTime();
        BigInteger product = a.multiply(b);
        long tMulEnd = System.nanoTime();

        // 4. 输出结果和计时
        System.out.println("乘积 = " + product.toString());

        long mulNanos = tMulEnd - tMulStart;
        long parseNanos = tParseEnd - tParseStart;
        long totalNanos = (tMulEnd - tParseStart); // 包含解析和乘法

        System.out.printf("仅乘法耗时: %d ns (%.6f ms)%n", mulNanos, mulNanos / 1_000_000.0);
        System.out.printf("解析耗时: %d ns (%.6f ms)%n", parseNanos, parseNanos / 1_000_000.0);
        System.out.printf("解析+乘法总耗时: %d ns (%.6f ms)%n", totalNanos, totalNanos / 1_000_000.0);
    }

}