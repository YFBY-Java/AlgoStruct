package com.yygx.algostruct.test;


import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LeetCode15 {


    public static List<List<Integer>> threeSum1(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>(List.of());
        Arrays.sort(nums);
        for (int i = 0; i < (length - 2); i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < (length - 1); j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);   // 排序
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < (length - 1); j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int rest = -nums[i] - nums[j];
                // 二分查找
                int k = Arrays.binarySearch(nums, j + 1, length, rest);
                // 如果找到目标元素
                if (k < 0) {
                    continue;
                }
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                // 跳过重复元素
                while (k < length - 1 && nums[k + 1] == rest) {
                    k++;
                }
            }
        }
        return res;
    }



    public static List<List<Integer>> threeSum3(int[] nums) {
        // 对数组进行排序，方便后续的双指针操作
        Arrays.sort(nums);
        int length = nums.length;  // 数组的长度
        List<List<Integer>> result = new ArrayList<>();  // 存储结果的列表

        // 遍历数组，寻找三元组
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复元素以避免重复的三元组
            if(i > 0 && nums[i] == nums[i-1]) continue;

            // 优化：如果当前数字与后面两个数字之和小于0，则可以结束当前循环
            if(nums[i] + nums[i+1] > - nums[i+2]) break;

            // 优化：如果当前数字小于数组最后两个数的负和，则继续下一个循环
            if(nums[i] < -(nums[length-1] + nums[length-2])) continue;

            // 使用双指针查找与当前数字的补数
            int left = i + 1, right = length - 1;
            while (left < right) {
                // 计算当前两个指针的和
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    // 找到一个三元组，将其添加到结果列表
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;  // 移动左指针
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    right--;  // 移动右指针
                    // 跳过重复元素
                    while (right > left && nums[right] == nums[right + 1]) right--;
                } else if (sum + nums[i] > 0) {
                    // 如果和大于0，说明右指针需要向左移动
                    right--;
                } else {
                    // 如果和小于0，说明左指针需要向右移动
                    left++;
                }
            }
        }
        return result;  // 返回所有找到的三元组
    }



    public static List<List<Integer>> threeSum3test(int[] nums) {
        // 先排序，用于去重
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            // 如果有重复的元素，跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] > -nums[i + 2]) break;
            if (nums[length - 1] + nums[length - 2] < -nums[i]) continue;

            int left = i + 1, right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    right--;
                    while (right > left && nums[right] == nums[right + 1]) right--;
                } else if (sum < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

}


/**
 * ——--------------------------------------------
 */
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        return nSum(nums, 3, 0);
    }

    public List<List<Integer>> nSum(int[] nums, int k, int target) {
        return new java.util.AbstractList<List<Integer>>() {
            final List<List<Integer>> res = new ArrayList<>();
            final List<Integer> path = new ArrayList<>();
            long min;

            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            public int size() {
                init();
                return res.size();
            }

            public void init() {
                if (res.isEmpty()) {
                    int n = nums.length;
                    long[] Arr = new long[n];
                    Arrays.sort(nums);
                    min = nums[0];
                    for (int i = 0; i < n; i++) {
                        Arr[i] = nums[i] - min;
                    }
                    long NewTarget = (long) target - (long) k * min;
                    C(false, Arr, n, k, NewTarget);
                }
            }

            public void C(boolean T, long[] a, int n, int k, long target) {
                if (n == 0 || k == 0) {
                    if (target == 0 && k == 0) {
                        res.add(new ArrayList<>(path));
                    }
                    return;
                }
                if (k == 2) {
                    if (!T && n != a.length && a[n] == a[n - 1]) {
                        return;
                    }
                    twoSum(a, 0, n - 1, target);
                    return;
                }
                if (n == k) {
                    if (!T && n != a.length && a[n] == a[n - 1]) {
                        return;
                    }
                    sumArr(a, n, target);
                    return;
                }
                if (check(a, n, k, target)) {
                    return;
                }
                C(false, a, n - 1, k, target);
                if (!T && n != a.length && a[n] == a[n - 1]) {
                    return;
                }
                if (target - a[n - 1] >= 0) {
                    path.add((int) (a[n - 1] + min));
                    C(true, a, n - 1, k - 1, target - a[n - 1]);
                    path.remove(path.size() - 1);
                }
            }

            void twoSum(long[] a, int l, int r, long target) {
                if (l >= r || a[r - 1] + a[r] < target || a[l] + a[l + 1] > target) {
                    return;
                }
                while (r > l) {
                    long sum = a[l] + a[r];
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        path.add((int) (a[l] + min));
                        path.add((int) (a[r] + min));
                        res.add(new ArrayList<>(path));
                        path.remove(path.size() - 1);
                        path.remove(path.size() - 1);
                        while (r > l && a[l] == a[l + 1]) {
                            l++;
                        }
                        while (r > l && a[r] == a[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }

            void sumArr(long[] a, int n, long target) {
                for (int i = n - 1; i > -1; i--) {
                    target -= a[i];
                    path.add((int) (a[i] + min));
                }
                if (target == 0) {
                    res.add(new ArrayList<>(path));
                }
                for (int i = n - 1; i > -1; i--) {
                    target += a[i];
                    path.remove(path.size() - 1);
                }
            }

            boolean check(long[] a, int n, int k, long target) {
                if (n - k < 0) {
                    return true;
                }
                long max = 0;
                long min = 0;
                for (int i = 0; i < k; i++) {
                    min += a[i];
                    max += a[n - i - 1];
                }
                if (target < min || target > max) {
                    return true;
                }
                return false;
            }
        };
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(new Solution().threeSum(nums));

    }
}





