package com.yygx.algostruct;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        int i = randomInt(0, 9);
        System.out.println(i);
    }


    // 随机生成整数
    public static int randomInt(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }
}