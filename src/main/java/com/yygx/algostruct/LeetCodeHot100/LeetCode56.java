package com.yygx.algostruct.LeetCodeHot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode56. 合并区间
 * <br>
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
        if (intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        if (intervals.length == 1) return intervals;
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = result.get(result.size() - 1);
            if (intervals[i][0] <= ints[1] && intervals[i][1] > ints[1]) {
                ints[1] = intervals[i][1];
            } else if (intervals[i][0] > ints[1]) {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[0][]);
    }


    public int[][] mergeTest(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        if (intervals.length == 1) return intervals;
        // 比较器，按照数组中的 每个子数组的第一个元素 进行排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        // 定义返回结果
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] nums = intervals[i];
            int[] last = result.get(result.size() - 1);
            if (nums[0] > last[1]) {
                result.add(nums);
            } else if (nums[1] < last[0]) {
                result.add(nums);
            } else {
                if (nums[0] < last[0]) last[0] = nums[0];
                if (nums[1] > last[1]) last[1] = nums[1];
            }
        }
        return result.toArray(new int[0][]);
    }


    public int[][] mergeTest2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        if (intervals.length == 1) return intervals;
        // 比较器，比较数组中的 子数组的第一个元素
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        // 定义结果数组
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = result.get(result.size() - 1);
            int[] interval = intervals[i];
            if (interval[0] > ints[1]) {
                result.add(interval);
            } else if (interval[1] > ints[1]) {
                ints[1] = interval[1];
            }
        }
        return result.toArray(new int[0][]);
    }


    public int[][] mergePre(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // 按照区间的起始点进行排序
        Arrays.sort(intervals, (interval1, interval2) -> {
            return Integer.compare(interval1[0], interval2[0]);
        });

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if (nextStart <= currentEnd) {
                // 有重叠，更新当前区间的结束点
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // 无重叠，将新区间添加到结果中
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[0][]);
    }


    public int[][] mergePro2(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        // 步骤一：对所有区间进行排序
        // 排序规则：按照每个区间的起始点（即子数组的第一个元素）从小到大排序
        Arrays.sort(intervals, (interval1, interval2) -> {
            return Integer.compare(interval1[0], interval2[0]);
        });
        // 也可以简化为：
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 步骤二：初始化合并后的第一个区间
        // 用 left 和 right 两个变量来跟踪当前正在合并的区间
        int left = intervals[0][0];  // 当前合并区间的起始点
        int right = intervals[0][1]; // 当前合并区间的结束点

        // 用于存储合并后的所有不重叠区间
        List<int[]> result = new ArrayList<>();

        // 步骤三：遍历排序后的区间数组，进行合并
        for (int i = 1; i < intervals.length; i++) {
            // 获取下一个区间的起始点
            int nextStart = intervals[i][0];
            // 判断是否有重叠：如果下一个区间的起始点 > 当前合并区间的结束点
            if (nextStart > right) {
                // 情况一：无重叠
                // 说明当前合并区间 [left, right] 已经结束，将其添加到结果列表中
                result.add(new int[]{left, right});

                // 并开始一个新的合并区间，其起始点和结束点就是下一个区间
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                // 情况二：有重叠或相邻
                // 更新当前合并区间的结束点，取当前区间的结束点和下一个区间的结束点中的较大值
                // 这样可以确保覆盖所有重叠的部分
                right = Math.max(intervals[i][1], right);
            }
        }

        // 步骤四：将最后一个正在合并的区间添加到结果列表中
        // 循环结束后，最后一个合并的区间还没有被添加，需要手动添加
        result.add(new int[]{left, right});

        // 将结果列表转换为二维数组并返回
        return result.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        // [[1,3],[2,6],[8,10],[15,18]]
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        //[[1,4],[4,5]]
        int[][] intervals = {{1, 4}, {4, 5}};
        LeetCode56 leetCode56 = new LeetCode56();
        System.out.println(Arrays.deepToString(leetCode56.mergeTest2(intervals)));
    }


}
