package com.yygx.algostruct.LeetCodeHot100;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode3. 无重复字符的最长子串
 * <br>
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


    /**
     * 暴力法解决无重复字符的最长子串问题
     *
     * @param s 输入字符串
     * @return 最长无重复字符子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        // 如果字符串为空或只有一个字符，直接返回其长度
        if (n <= 1) {
            return n;
        }
        // 外层循环：确定子串的起始位置 i
        for (int i = 0; i < n; i++) {
            // 使用哈希集合存储当前子串中的字符，用于快速判断重复
            Set<Character> charSet = new HashSet<>();
            // 内层循环：确定子串的结束位置 j
            for (int j = i; j < n; j++) {
                char currentChar = s.charAt(j);
                // 检查当前字符是否已在集合中
                if (charSet.contains(currentChar)) {
                    // 如果重复，说明从 i 开始的最长无重复子串已经找到，
                    break;
                } else {
                    // 如果不重复，将字符加入集合
                    charSet.add(currentChar);
                    // 更新最长长度
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }



    public int lengthOfLongestSubstringPro(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }






    /**
     * 辅助函数：判断子串 s[start...end] 是否含有重复字符
     *
     * @param s     原始字符串
     * @param start 子串起始索引
     * @param end   子串结束索引
     * @return 如果无重复，返回 true；否则返回 false
     */
    private boolean isUnique(String s, int start, int end) {
        Set<Character> charSet = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char currentChar = s.charAt(i);
            // 如果哈希集合中已存在该字符，说明有重复
            if (charSet.contains(currentChar)) {
                return false;
            }
            // 否则，将字符添加到集合中
            charSet.add(currentChar);
        }
        return true;
    }





    public static void main(String[] args) {
        // "abcabcbb"
        System.out.println(new LeetCode3().lengthOfLongestSubstring("dvdf"));
    }
}