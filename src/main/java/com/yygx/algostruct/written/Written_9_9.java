package com.yygx.algostruct.written;


import java.util.Arrays;
import java.util.Scanner;

// 过河，小船每次只能带两个，过河时间和体重较重的人相同，求最短时间
public class Written_9_9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 记录有几组数据

        for (int i = 0; i < n; i++) {
            // 第一行记录这组数据有几个人
            int num = in.nextInt();
            int[] arr = new int[num];  // 每个人的体重
            for (int j = 0; j < num; j++) {
                arr[j] = in.nextInt();
            }
            Arrays.sort(arr);  // 排序
            // 从后往前遍历
            int sum = 0;
            // 最大的和最小的一起，然后最小的回来载人
            for (int p = 1; p < arr.length; p++) {
                sum += arr[p];
            }
            // 计算回来的时间 回来次数 * 体重最小
            sum += arr[0] * (arr.length - 2);
            System.out.println(sum);
        }
    }

}