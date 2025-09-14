package com.yygx.algostruct.written;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//小红书笔试
public class Written_9_14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // 第一行为数据组数
            int groupNum = in.nextInt();
            for (int i = 0; i < groupNum; i++) {
                int num = in.nextInt();  // 当前点赞数
                if (num == 1 || num == 0) {
                    System.out.println("NO");
                    continue;
                }
                boolean b = primeNumberSum(num);
                if (b) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static boolean primeNumberSum(int n) {
        if (n == 2) return false;
        // 先创建一个数组，用来存储 小于等于 n 的 质数
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);  // 先填充都是质数
        primes[0] = false;
        primes[1] = false; // 0 和 1 排除
        for (int i = 2; i < n + 1; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        boolean prime = primes[n];
        if (prime){
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (primes[i]) list.add(i);
        }
        int sum = 0;
        for (Integer integer : list) {
            if(integer * integer == n) continue;
            if (n % integer == 0) {
                sum += integer;
            }
        }
        return sum % 2 != 0;
    }

}