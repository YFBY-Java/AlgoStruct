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
        Arrays.sort(nums); // 首先对数组进行排序，以便后续处理和去重
        int length = nums.length; // 获取数组长度
        List<List<Integer>> result = new ArrayList<>(); // 初始化结果列表，用于存储符合条件的三元组

        // 遍历数组，固定第一个数
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复元素，以避免结果中出现重复的三元组
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 如果当前数加上后两个最小的数仍然大于负的第三个数，则无必要继续
            if (nums[i] + nums[i + 1] > -nums[2]) break;

            // 如果当前数大于负的后两个数的和，则无必要继续
            if (nums[i] > -(nums[length - 1] + nums[length - 2])) continue;

            // 定义左右指针，左指针从当前数的下一个位置开始，右指针从数组末尾开始
            int left = i + 1, right = length - 1;

            // 当左指针小于右指针时，执行循环
            while (left < right) {
                // 计算两个指针所指向的数的和
                int sum = nums[left] + nums[right];

                // 如果和等于当前固定的数的负值，说明找到了一个三元组
                if (sum == -nums[i]) {
                    // 将三元组添加到结果列表中
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 移动左指针，并跳过重复元素
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;

                    // 移动右指针，并跳过重复元素
                    right--;
                    while (right > left && nums[right] == nums[right + 1]) right--;
                }
                // 如果和大于当前固定数的负值，移动右指针以减小和
                else if (sum + nums[i] > 0) {
                    right--;
                }
                // 如果和小于当前固定数的负值，移动左指针以增大和
                else {
                    left++;
                }
            }
        }
        return result; // 返回所有找到的三元组
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
        int[] nums = { 0, 0, 0 };
        System.out.println(new Solution().threeSum(nums));

    }
}





