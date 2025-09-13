package com.yygx.algostruct.written;

import java.util.Scanner;
import java.util.*;

// 去哪儿旅行 笔试

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Written_9_13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();   // 有几组数据
            for (int i = 0; i < a; i++) {
                int b = in.nextInt();   // 本组数据有几个
                ArrayList<Integer> array = new ArrayList<>();
                for (int num = 0; num < b; num++) {
                    array.add(in.nextInt());
                }
                int[] leftSum = new int[b];
                int[] rightSum = new int[b];

                int[] leftMax = new int[b];
                int[] rightMax = new int[b];

                int max = 0;
                int sum = 0;
                for (int left = 0; left < b; left++) {
                    sum = sum + array.get(left);
                    leftSum[left] = sum;
                    max = Math.max(max, array.get(left));
                    leftMax[left] = max;
                }
                max = 0;
                sum = 0;
                for (int right = b - 1; right >= 0; right--) {
                    sum = sum + array.get(right);
                    rightSum[right] = sum;
                    max = Math.max(max, array.get(right));
                    rightMax[right] = max;
                }
                // 记录两边差值的数组
                int[] ab = new int[b]; // 左减右，为负说明右大，为正说明左大
                for (int j = 0; j < b - 1; j++) {
                    ab[j] = leftSum[j] - rightSum[j + 1];
                }
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < b - 1; k++) {
                    int left = ab[k] - leftMax[k];
                    int right = ab[k] + rightMax[k + 1];
                    // 判断哪个绝对值大
                    left = Math.abs(left);
                    right = Math.abs(right);
                    int currentMin = Math.max(left, right);
                    min = Math.min(min, currentMin);
                }
                System.out.println(min);
                min = 0;
            }
        }
    }
}