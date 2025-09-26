package com.yygx.algostruct.writtenTest;

import java.util.Arrays;
import java.util.Scanner;

// 阿里灵犀互娱笔试准备
public class LingXiTest {


    /**
     * LeetCode455. 分发饼干
     * <br/>
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。<br/>
     * 每个孩子最多只能得到一块饼干。<br/>
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；<br/>
     * 并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i，<br/>
     * 这个孩子会得到满足。<br/>
     * 你的目标是满足尽可能多的孩子，并输出这个最大数值。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入: g = [1,2,3], s = [1,1]<br/>
     * 输出: 1<br/>
     * 解释：<br/>
     * 你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1, 2, 3。<br/>
     * 虽然你有两块小饼干，由于它们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。<br/>
     * 所以你应该输出 1。<br/>
     * <br/>
     * 示例 2：<br/>
     * 输入: g = [1,2], s = [1,2,3]<br/>
     * 输出: 2<br/>
     * 解释：<br/>
     * 你有两个孩子和三块小饼干，2 个孩子的胃口值分别是：1, 2。<br/>
     * 你拥有的饼干数量和尺寸都足以让所有孩子满足。<br/>
     * 所以你应该输出 2。<br/>
     */
    public int findContentChildren(int[] g, int[] s) {
        // 对两个数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0;
        int indexG = 0;
        int count = 0;
        while (index < s.length && indexG < g.length) {
            int currentCookies = s[index];
            if (currentCookies >= g[indexG]) {
                count++;
                indexG++;
            }
            index++;
        }
        return count;
    }

    public int findContentChildrenTest(int[] g, int[] s) {
        // 排序
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int i : s) {
            if (index < g.length && i >= g[index]) {
                index++;
            }
        }
        return index;
    }

    public void miners() {
        Scanner scanner = new Scanner(System.in);
        // 读取矿工数量n 和 宝石数量 m
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        // 读取矿工能力数组
        int[] workers = new int[n];
        for (int i = 0; i < n; i++) {
            workers[i] = scanner.nextInt();
        }
        // 读取宝石硬度数组
        int[] gems = new int[m];
        for (int i = 0; i < m; i++) {
            gems[i] = scanner.nextInt();
        }
        // 排序
        Arrays.sort(workers);
        Arrays.sort(gems);
        int count = 0;
        for (int worker : workers) {
            if (count < gems.length && worker >= gems[count]) {
                count++;
            }
        }
        System.out.println(count);
    }


    /**
     * 灵小犀的数字游戏
     * <br/>
     * 给定一个长度为 n 的整数序列，灵小犀可以进行若干次操作，每次操作可以选择序列中的一个元素并将其删除。<br/>
     * 删除元素的条件是：删除的元素必须是其左边所有元素的和等于其右边所有元素的和。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入：arr = [1, 3, 2, 4, 2]<br/>
     * 输出：0<br/>
     * 解释：没有可以删除的元素，所有元素的左边和与右边和都不相等。<br/>
     * <br/>
     * 示例 2：<br/>
     * 输入：arr = [1, 2, 3, 2, 1]<br/>
     * 输出：1<br/>
     * 解释：可以删除第 3 个元素 3，因为左边元素和（1 + 2 = 3）等于右边元素和（2 + 1 = 3）。<br/>
     * <br/>
     * 输入描述：<br/>
     * 第一行包含一个整数 n，表示序列长度。<br/>
     * 第二行包含 n 个整数，表示给定的整数序列。<br/>
     * <br/>
     * 输出描述：<br/>
     * 输出一个整数，表示最多能删除的元素个数。<br/>
     */
//    public static int maxDeletions(List<Integer> nums) {
//
//    }


    /**
     * LeetCode487. 最大连续 1 的个数 II
     * <br/>
     * 给定一个二进制数组 nums，如果最多可以翻转一个 0，<br/>
     * 返回数组中连续 1 的最大个数。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入：nums = [1,0,1,1,0]<br/>
     * 输出：4<br/>
     * 解释：翻转第一个 0 可以得到最长的连续 1，翻转后最大连续 1 的个数为 4。<br/>
     * <br/>
     * 示例 2：<br/>
     * 输入：nums = [1,0,1,1,0,1]<br/>
     * 输出：4<br/>
     * <br/>
     * 提示：<br/>
     * 1 <= nums.length <= 10^5<br/>
     * nums[i] 不是 0 就是 1。<br/>
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int maxLen = 0;
        int count0 = 0;  // 记录 0 个数，用来处理没有0的情况
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                count0++;
                int left = 0;  // 左边连续1的个数
                int right = 0;  // 右边连续1的个数
                for (int l = i - 1; l >= 0 && nums[l] == 1; l--) {
                    left++;
                }
                for (int r = i + 1; r < len && nums[r] == 1; r++) {
                    right++;
                }
                // 更新 maxLen
                maxLen = Math.max(maxLen, left + 1 + right);
            }
        }
        // 如果数组全是1，maxLen 可能还没更新
        if(count0 == 0){
            return len;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // [1,1,0,1]
        int[] nums = {1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }


}