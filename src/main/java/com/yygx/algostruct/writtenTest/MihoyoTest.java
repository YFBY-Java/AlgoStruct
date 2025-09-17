package com.yygx.algostruct.writtenTest;

import java.util.*;

// 米哈游笔试准备
public class MihoyoTest {

    /**
     * 字符串整体移动替换
     * <p>
     * 题意：给定一个长度为 n 的字符串 s，从左到右依次处理每个字符：
     * 1. 如果是大写字母 (A-Z)，则替换为字母表中的下一个字母，Z 替换为 A。
     * 2. 如果是小写字母 (a-z)，则替换为字母表中的上一个字母，a 替换为 z。
     * 3. 如果是数字字符 (0-9)，则替换为该数字加 1，9 替换为 0。
     * 4. 如果是其他字符，则替换为下划线 "_"。
     */
    public static String transform(String s) {
        // 用StringBuilder存储
        StringBuilder stringBuilder = new StringBuilder();
        // 处理字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (c == 'Z') {
                    stringBuilder.append('Z');
                } else {
                    stringBuilder.append((char) (c + 1));
                }
            } else if (c >= 'a' && c <= 'z') {
                if (c == 'a') {
                    stringBuilder.append('z');
                } else {
                    stringBuilder.append((char) (c - 1));
                }
            } else if (c >= '0' && c <= '9') {
                if (c == '9') {
                    stringBuilder.append('0');
                } else {
                    stringBuilder.append((char) (c + 1));
                }
            } else {
                stringBuilder.append('_');
            }
        }
        return stringBuilder.toString();
    }


    /**
     * LeetCode40. 组合总和 II
     * <br/>
     * 给定一个候选人编号的集合 candidates 和一个目标数 target，<br/>
     * 找出 candidates 中所有可以使数字和为 target 的组合。<br/>
     * candidates 中的每个数字在每个组合中只能使用一次。<br/>
     * 注意：解集不能包含重复的组合。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8<br/>
     * 输出: [[1,1,6],[1,2,5],[1,7],[2,6]]<br/>
     * <br/>
     * 示例 2：<br/>
     * 输入: candidates = [2,5,2,1,2], target = 5<br/>
     * 输出: [[1,2,2],[5]]<br/>
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length; // 数组长度
        Set<List<Integer>> resultSet = new HashSet<>(); // 使用 Set 去重，避免重复组合

        Arrays.sort(candidates); // 先对数组排序，方便之后去重和组合处理

        // 使用子集枚举法：总共有 2^n 个子集
        // mask 代表当前子集的二进制表示
        // 例如 mask = 5（二进制 0101）表示选择第 0 和第 2 个元素
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> tempList = new ArrayList<>(); // 存储当前子集元素
            int sum = 0; // 当前子集元素和

            // 遍历每个元素，判断它是否在当前子集中
            for (int j = 0; j < n; j++) {
                // 如果 mask 的第 j 位为 1，说明 candidates[j] 被选中
                if ((mask & (1 << j)) != 0) {
                    tempList.add(candidates[j]); // 加入子集
                    sum += candidates[j]; // 累加子集和
                }
            }

            // 如果当前子集和等于目标值，则加入结果集合
            if (sum == target) {
                resultSet.add(tempList); // Set 自动去重
            }
        }
        // 将 Set 转换为 List 返回
        return new ArrayList<>(resultSet);
    }


    /**
     * LeetCode1025. 除数博弈
     * <br/>
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动，爱丽丝先手。<br/>
     * 最初，黑板上有一个数字 n。每个玩家的回合中，需要执行以下操作：<br/>
     * 1. 选出任一 x，满足 0 < x < n 且 n % x == 0。<br/>
     * 2. 用 n - x 替换黑板上的数字 n。<br/>
     * 如果玩家无法执行操作，则输掉游戏。<br/>
     * <br/>
     * 返回 true 当且仅当爱丽丝在游戏中取得胜利，假设双方都以最佳策略参与。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入：n = 2<br/>
     * 输出：true<br/>
     * 解释：爱丽丝选择 1，鲍勃无法进行操作。<br/>
     * <br/>
     * 示例 2：<br/>
     * 输入：n = 3<br/>
     * 输出：false<br/>
     * 解释：爱丽丝选择 1，鲍勃选择 1，爱丽丝无法进行操作。<br/>
     */
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    /**
     * 除数博弈（尝试计数法）
     *
     * @param n 黑板上的数字
     * @return 爱丽丝是否获胜
     */
    public boolean divisorGameTest(int n) {
        // 特殊情况：n = 1 时，爱丽丝无法操作 → 输
        if (n == 1) {
            return false;
        }
        // dpTable[i] 表示当黑板数字为 i 时，当前玩家是否能获胜
        boolean[] dpTable = new boolean[n + 1];
        // 初始化边界情况
        dpTable[0] = false; // n = 0 不存在操作 → 输
        dpTable[1] = false; // n = 1 无法选择 x → 输
        dpTable[2] = true;  // n = 2 可选择 x = 1 → 对手 n = 1 → 对手输 → 当前玩家赢
        // 从 3 到 n，依次计算每个数字的胜负情况
        for (int i = 3; i <= n; i++) {
            // 枚举所有小于 i 的数字 j，尝试作为因子 x
            for (int j = 1; j < i; j++) {
                // 如果当前数字 i 已经判定为必胜，就没必要再判断其他 j
                if (dpTable[i]) {
                    continue;
                }

                // 如果 j 是 i 的因子（合法操作）
                if (i % j == 0) {
                    // 如果执行 i - j 后，对手处于必输状态（dp[i-j] = false）
                    // 那么当前玩家就能获胜
                    dpTable[i] = !dpTable[i - j];
                }
            }
        }
        // 返回 n 对应的状态，表示爱丽丝是否能获胜
        return dpTable[n];
    }



    /**
     * 题意简述：
     * 给定长度为 n 的两个数组 a 和 b。
     * 第 i 天目标为 a[i]，实际为 b[i]。
     * 若 b[i] < a[i]，令 deficit = a[i] - b[i]：
     *   - 若到第 i 天为止累计实际 sumB >= 累计目标 sumA，则消耗 deficit 能量点；
     *   - 否则消耗 2 * deficit 能量点。
     * 计算总额外消耗能量点。
     *
     * 实现说明：
     * - 使用 long 保存累计和与答案，防止溢出。
     * - 单次遍历，维护 sumA 和 sumB，按规则累加 cost。
     * - 时间复杂度 O(n)，额外空间 O(1)。
     */
    public long totalExtraEnergy(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            throw new IllegalArgumentException("数组为空或长度不一致");
        }
        long sumA = 0L;      // 到当前天为止的累计目标
        long sumB = 0L;      // 到当前天为止的累计实际
        long cost = 0L;      // 总额外消耗

        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];

            if (b[i] < a[i]) {
                long deficit = (long) a[i] - (long) b[i];
                if (sumB >= sumA) {
                    cost += deficit;      // 累计实际不小于累计目标，消耗 deficit
                } else {
                    cost += 2L * deficit; // 累计实际小于累计目标，消耗 2*deficit
                }
            }
        }
        return cost;
    }



    public static void main(String[] args) {
        MihoyoTest mihoyoTest = new MihoyoTest();
        boolean b = mihoyoTest.divisorGameTest(10);
        System.out.println(b);
    }


}