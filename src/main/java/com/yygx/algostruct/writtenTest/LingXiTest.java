package com.yygx.algostruct.writtenTest;

import java.util.Arrays;

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
            if(index < g.length && i >= g[index]){
                index++;
            }
        }
        return index;
    }


}