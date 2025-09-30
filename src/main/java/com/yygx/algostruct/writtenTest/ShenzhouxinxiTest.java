package com.yygx.algostruct.writtenTest;


import java.util.Scanner;

// 神州信息笔试准备
public class ShenzhouxinxiTest {



    // 给等腰三角形的底和高，求此三角形的周长（保留两位小数）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取底边和高度
        double bottom = scanner.nextDouble();
        double high = scanner.nextDouble();
        // 计算边长
        double edge = Math.sqrt((bottom / 2) * (bottom / 2 ) + high*high);
        // 计算周长
        double perimeter = bottom + 2 * edge;
        System.out.printf("%.2f\n", perimeter);
    }


}