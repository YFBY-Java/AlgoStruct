package com.yygx.algostruct.writtenTest;


import java.util.Arrays;

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


}