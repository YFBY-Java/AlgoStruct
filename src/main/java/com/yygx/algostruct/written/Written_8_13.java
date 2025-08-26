package com.yygx.algostruct.written;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Written_8_13 {


    // 拼音九键输入法，字母组合，map 仅包含数字2-9的字符串，返回所有能表示的字母组合
    public List<String> monogram(String digits){
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        // 定义一个map 映射数字和 对应字母
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            String letters = map.get(digit);
            // 新的结果列表
            List<String> newResult = new ArrayList<>();
            // 对于当前结果中的每个字符串
            for (String str : result) {
                // 将当前数字对应的每个字母追加到字符串后面
                for (int j = 0; j < letters.length(); j++) {
                    newResult.add(str + letters.charAt(j));
                }
            }
            // 更新结果列表
            result = newResult;
        }
        return result;
    }


    //  结构： ID  PID(父节点ID)   NAME
    // 树形遍历  打印出每个节点的深度
    public void treeTraversal(List<TreeNode> tree) {

    }


    public static class TreeNode {
        private Integer ID;
        private Integer PID;
        private String name;
    }


    @Test
    public void testMonogram() {
        String digits = "23";
        List<String> result = monogram(digits);
        System.out.println(result);
    }




}