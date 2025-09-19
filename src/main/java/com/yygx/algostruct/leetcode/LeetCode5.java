package com.yygx.algostruct.leetcode;


/**
 * LeetCode5. 最长回文子串
 * <br/>
 * 给定一个字符串 s，找到 s 中最长的回文子串。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：s = "babad"<br/>
 * 输出："bab"<br/>
 * 解释："aba" 同样是符合题意的答案。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：s = "cbbd"<br/>
 * 输出："bb"<br/>
 * <br/>
 * 提示：<br/>
 * 1 <= s.length <= 1000<br/>
 * s 仅由数字和英文字母组成。<br/>
 */
public class LeetCode5 {


//    // 中心扩展法
//    public String longestPalindrome(String s) {
//        if(s == null || s.length() < 2) return s;
//        //  记录最长回文串的长度 和 起始索引
//        int max = 0;
//        int start = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            // 奇数回文串
//            int odd = centerExpansion(s, i, i);
//            // 偶数回文串
//            int even = centerExpansion(s, i, i + 1);
//            int currentMax = Math.max(odd,even);
//            if(currentMax > max){
//                max = currentMax;
//                start = i - (max - 1) / 2;
//            }
//        }
//        return s.substring(start,start + max);
//    }
//
//    // 返回的是回文串的长度
//    public int centerExpansion(String s,int left,int right){
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
//            left--;
//            right++;
//        }
//        return right -  left - 1;
//    }


    // 中心扩展法
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;
        int max = 0; // 最长回文串长度
        int start = 0;  // 最长回文串的开始位置

        for (int i = 0; i < s.length(); i++) {
            // 奇数
            int odd = centerExpansion(s, i, i);
            // 偶数
            int even = centerExpansion(s, i, i + 1);
            int current = Math.max(odd, even);
            if (current > max) {
                max = current;
                start = i - (current - 1) / 2;
            }
        }
        return s.substring(start, start + max);
    }


    // 中心扩展  返回值是长度
    public int centerExpansion(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


}