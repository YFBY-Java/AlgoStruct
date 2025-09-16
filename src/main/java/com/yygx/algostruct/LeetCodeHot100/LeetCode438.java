package com.yygx.algostruct.LeetCodeHot100;

import cn.hutool.core.lang.hash.Hash;

import java.util.*;

public class LeetCode438 {

    public List<Integer> findAnagrams(String s, String p) {
        // 转换为字符数组
        char[] charArray = p.toCharArray();
        // 把字符都添加到map
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int pLen = p.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length() - pLen; i++) {
            // 拷贝一个map，用于判断
            HashMap<Character, Integer> tempMap = new HashMap<>(map);
            for (int j = i; j < i + pLen && j < s.length(); j++) {
                char c = s.charAt(j);
                if (!tempMap.containsKey(c)) {
                    break;
                }
                Integer integer = tempMap.get(c);
                if (integer == 1) {
                    tempMap.remove(c);
                } else {
                    tempMap.put(c, integer - 1);
                }
                if (tempMap.isEmpty()) {
                    list.add(i);
                }
            }
        }
        return list;
    }


    public List<Integer> findAnagramsTest(String s, String p) {
        // 将 p 的字符统计到 map
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int pLen = p.length();
        List<Integer> list = new ArrayList<>();

        // 外层循环只遍历到 s.length() - pLen
        for (int i = 0; i <= s.length() - pLen; i++) {
            // 拷贝 map 用于当前窗口判断
            HashMap<Character, Integer> tempMap = new HashMap<>(map);
            int j = 0;
            for (; j < pLen; j++) {
                char c = s.charAt(i + j);
                if (!tempMap.containsKey(c)) {
                    break; // 当前窗口不是异位词
                }
                tempMap.put(c, tempMap.get(c) - 1);
                if (tempMap.get(c) == 0) {
                    tempMap.remove(c);
                }
            }
            // 内层循环完整执行完且 tempMap 空，说明当前窗口是异位词
            if (j == pLen && tempMap.isEmpty()) {
                list.add(i);
            }
        }

        return list;
    }


    // 滑动窗口
    public List<Integer> findAnagramsPro(String s, String p) {
        // 结果数组
        ArrayList<Integer> result = new ArrayList<>();
        // 如果匹配串比原串长，直接返回空数组
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen) return result;
        // 初始化两个 字符数组，记录26个英文字符各出现几次
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < pLen; i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        // 进行一次比较
        if (Arrays.equals(sArr, pArr)) {
            result.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            sArr[s.charAt(i) - 'a']--;
            sArr[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sArr, pArr)) {
                result.add(i + 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LeetCode438 leetCode438 = new LeetCode438();
        System.out.println(leetCode438.findAnagrams("cbaebabacd", "abc"));
    }


}