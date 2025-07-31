package com.yygx.algostruct.LeetCodeHot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。<br/>
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]<br/>
 * 输出：[[1,6],[8,10],[15,18]]<br/>
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：intervals = [[1,4],[4,5]]<br/>
 * 输出：[[1,5]]<br/>
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。<br/>
 */

public class LeetCode56 {


    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        if(intervals.length == 1) return intervals;
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i = 1;i<intervals.length;i++){
            int[] ints = result.get(result.size() - 1);
            if(intervals[i][0] <= ints[1] && intervals[i][1] > ints[1]){
                ints[1] = intervals[i][1];
            }else if (intervals[i][0] > ints[1]){
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        // [[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        LeetCode56 leetCode56 = new LeetCode56();
        System.out.println(Arrays.deepToString(leetCode56.merge(intervals)));
    }


}
