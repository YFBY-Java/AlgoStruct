package com.yygx.algostruct.interview;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 12.31快手测开
 * 找到字符串的所有排列，并以字母顺序返回所有不同的排列
 */
public class StrFullSet {
    public static List<String> findPermutations(String input) {
        // 用于存储最终的排列结果
        Set<String> result = new TreeSet<>();
        // 将字符串转换为字符数组，方便处理
        char[] chars = input.toCharArray();
        // 调用回溯方法进行排列组合
        backtrack(chars, 0, result);
        // 返回结果，转为列表
        return new ArrayList<>(result);
    }

    private static void backtrack(char[] chars, int index, Set<String> result) {
        // 如果当前排列完成，则加入到结果集中
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            // 交换字符位置
            swap(chars, index, i);
            // 递归调用下一层
            backtrack(chars, index + 1, result);
            // 回溯时交换回来
            swap(chars, index, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        // 示例输入
        String input = "abc";
        // 调用方法获取结果
        List<String> permutations = findPermutations(input);
        // 打印结果
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}