package com.yygx.algostruct.leetcode;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode3. 无重复字符的最长子串
 * 给定一个字符串 s，请你找出其中不含有重复字符的最长子串的长度。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入: s = "abcabcbb"<br/>
 * 输出: 3<br/>
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入: s = "bbbbb"<br/>
 * 输出: 1<br/>
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。<br/>
 * <br/>
 * 示例 3：<br/>
 * 输入: s = "pwwkew"<br/>
 * 输出: 3<br/>
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。<br/>
 * 请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。<br/>
 */

public class LeetCode3 {


    public int lengthOfLongestSubstring(String s) {
        //  无重复最长字串，滑动窗口
        // 定义一个set
        Set<Character> set = new HashSet<>();
        // 定义左右指针
        int left = 0;
        int right = 0;
        // 定义当前长度 和 最大长度
        int currentLen = 0;
        int maxLen = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            if (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            } else {
                right++;
                set.add(c);
            }
            currentLen = right - left;
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }


    @Test
    public void test() {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }


}