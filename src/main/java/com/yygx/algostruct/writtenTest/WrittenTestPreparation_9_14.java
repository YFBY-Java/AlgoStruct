package com.yygx.algostruct.writtenTest;


import java.util.Arrays;
import java.util.Scanner;

// 小红书笔试准备
// 9月14日 后端开发工程师-企业效率
public class WrittenTestPreparation_9_14 {

    // LeetCode204   计数质数
    // 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
    public int countPrimes(int n) {
        // n小于等于2的时候，没有质数  (因为要返回的是小于n的质数的数量)
        if (n <= 2) return 0;
        int count = 0;  // 质数数量
        for (int i = 2; i < n; i++) {
            boolean is = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    is = false;
                    break;
                }
            }
            if (is) count++;
        }
        return count;
    }


    // 质数数量
    // 埃氏筛 (埃拉托斯尼特筛)
    public int countPrimesPro(int n) {
        if (n <= 2) return 0;  // 返回的是小于n的质数
        //创建一个布尔数组，表示索引位置是否是质数
        boolean[] isPrimes = new boolean[n];
        // 假设所有的数都是质数
        Arrays.fill(isPrimes, true);
        // 将 0 和 1 设置为不是质数
        isPrimes[0] = false;
        isPrimes[1] = false;

        // 遍历数组，从2开始，依次将其倍数标记为 非质数
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {  // 如果当前元素还是质数
                // 从 i * i 开始遍历，因为 比 i 小的倍数已经被更小的质数筛选过了
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        int count = 0;
        // 遍历 isPrimes 数组，数出质数数量
        for (boolean isPrime : isPrimes) {
            if (isPrime) count++;
        }
        return count;
    }


    // 质数数量 埃氏筛
    public int countPrimesProTest(int n) {
        if (n <= 2) return 0;
        // 定义一个布尔数组，表示索引位置是否是质数
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);  // 全部填充为 true
        isPrimes[0] = false;
        isPrimes[1] = false;   // 0 和 1 不是素数
        for (int i = 2; i * i < n; i++) {   // 从2开始
            if (isPrimes[i]) {  // 当前元素还是质数
                // 从 i 开始遍历，i之前的元素的倍数都遍历过了
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        int count = 0;
        // 遍历布尔数组，计算出有多少质数
        for (int i = 0; i < n; i++) {
            if(isPrimes[i]) count++;
        }
        return count;
    }

    /**
     * 删除数组中的元素使相邻差值不超过 d
     * <br/>
     * 给定一个整数数组 nums 和整数 d，<br/>
     * 可以删除数组中的元素，使得保留下来的元素任意两个相邻元素差值都不超过 d。<br/>
     * <br/>
     * 算法思路：<br/>
     * 1. 对数组排序。<br/>
     * 2. 使用动态规划，dp[i] 表示从索引 1 到 i 最多可以保留多少个元素。<br/>
     * 3. 遍历数组，二分查找左边第一个与 nums[i] 差值大于 d 的元素索引 j。<br/>
     * 4. 更新 dp[i] = dp[j] + 1。<br/>
     * 5. 遍历 dp 数组取全局最大值 maxKeep。<br/>
     * 6. 答案 = n - maxKeep。若删除数量为奇数，答案需减 1。<br/>
     * <br/>
     * 示例：<br/>
     * 输入：nums = [1,3,6,10], d = 3<br/>
     * 输出：1<br/>
     * 解释：保留下来的子数组可以是 [1,3,6]，删除 10，删除数量为 1（奇数），所以答案减 1。<br/>
     */
    public void LargestSubsequence() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a); // 排序，保证递增

            int maxKeep = 0;
            // 暴力枚举每个子序列结尾
            for (int i = 0; i < n; i++) {
                int count = 1; // 至少保留自己
                int last = a[i];
                for (int j = i + 1; j < n; j++) {
                    if (a[j] - last <= d) {
                        count++;
                        last = a[j]; // 更新最后一个保留的数
                    }
                }
                maxKeep = Math.max(maxKeep, count);
            }

            int ans = n - maxKeep;
            if (ans % 2 == 1) ans--; // 删除数量为奇数减一
            System.out.println(ans);
        }
        sc.close();
    }




}