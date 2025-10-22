package com.yygx.algostruct.written.baidu;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.*;

// 百度笔试
public class BaiDu {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        long[] arr = new long[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextLong();
//        }
//
//        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for (long x : arr) {
//            pq.offer(x);
//        }
//        long min = Arrays.stream(arr).min().orElse(1L);
//        int ops = 0;
//        while (pq.peek() > 2 * min) {
//            long top = pq.poll();
//            long x = min;
//            long y = top - min;
//            pq.offer(x);
//            pq.offer(y);
//            ops++;
//        }
//        System.out.println(ops);
//    }


    public static void main(String[] args) {

        numberOfOperations();
    }

    private static void numberOfOperations() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            if (a[i] < min) min = a[i];
        }
//        Arrays.sort(a);
        long ans = 0;
        long limit = 2 * min;
        for (int i = 0; i < n; i++) {
            ans += (a[i] + limit - 1) / limit - 1;
        }
        System.out.println(ans);
    }




    private static void luckySubString() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt(), k = scanner.nextInt();
            String s = scanner.next();
            int half = k / 2;
            // 构建前缀和数组
            int[] pre = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + s.charAt(i) - '0';
            }
            int ans = 0;
            // 枚举所有长度为 k 的 子串
            for (int i = 0; i + k <= n; i++) {
                int sum1 = pre[i + half] - pre[i];  // 前半部分和
                int sum2 = pre[i + k] - pre[i + half]; // 后半部分和
                if(sum1 == sum2) ans++;
            }
            System.out.println(ans);
        }
    }


}