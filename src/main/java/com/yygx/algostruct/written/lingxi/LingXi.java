package com.yygx.algostruct.written.lingxi;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 阿里巴巴灵犀互娱 笔试
public class LingXi {


    // 判断数组能否删除一个元素后是严格递增的
    public boolean check (int[] nums) {
        int len = nums.length;
        int count = 0; // 记录删除次数
        for (int i = 1; i < len; i++) {
            if(nums[i] <= nums[i - 1]){
                count++;
                if(count > 1) return false;
                if(i > 1 && nums[i] <= nums[i - 2]){
                    nums[i] = nums[i - 1];  // 等价于删除 nums[i]
                }
            }
        }
        return true;
    }



    /**
     * LeetCode1065. 字符串的索引对
     * <br/>
     * 给出字符串 text 和字符串列表 words（列表中的字符串不重复），<br/>
     * 返回所有的索引对 [i, j]，使得在索引对范围内的子字符串 text[i]...text[j] （包括 i 和 j）属于字符串列表 words。<br/>
     * 返回结果按升序输出。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入：text = "thestoryofleetcodeandme", words = ["story","fleet","bar","foo"]<br/>
     * 输出：[[3,7],[9,13],[18,20],[21,23]]<br/>
     */
    public int[][] indexPairs (String text, String[] words) {
        List<int[]> result = new ArrayList<>();
        for (String word : words) {
            int wordLen = word.length();
            for (int i = 0; i <= text.length() - wordLen; i++) {
                if(text.substring(i,i + wordLen).equals(word)){
                    result.add(new int[]{i, i + wordLen - 1});
                }
            }
        }
        // 按照升序排列
        result.sort((a,b) ->{
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else {
                return a[1] - b[1];
            }
        });
        // 转化为 int[][]
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }


    // 两数之和
    public ArrayList<Integer> twoSum (int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(map.get(num));
                list.add(i);
                return list;
            }else {
                map.put(nums[i],i);
            }
        }
        // 返回一个空集合
        return new ArrayList<>();
    }

}