package com.yygx.algostruct.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode242.有效的字母异位词
 * <p>
 *     给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
 * 字母异位词
 * 。
 * </p>
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if(slen != tlen) return false;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            Integer val = map.get(c);
            if(val != null && val > 0){
                map.put(c, map.get(c) - 1);
            }else{
                return false;
            }
        }
        return true;
    }


    /**
     * 字母表法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramPro(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength != tLength){
            return false;
        }
        int[] cnts = new int[26];
        for(char c : s.toCharArray()){
            cnts[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            cnts[c - 'a']--;
            if(cnts[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {
        LeetCode242 leetCode242 = new LeetCode242();
        String s = "aaca";
        String t = "ccac";
        System.out.println(leetCode242.isAnagram(s, t));
    }

}