package com.yygx.algostruct.datastructure.array;

/**
 * <p>
 * 注释：工具类
 * </p>
 * Author: <a href="https://github.com/YFBY-Java" target="_blank">吟风抱月</a>
 */
public class ArrayMaxLength {

    public static void main(String[] args) {
        printMemoryInfo();
        findMaxIntSize();
//        int[] test = new int[2092957692];
        printMemoryInfo();
//        findMaxByteSize();
//        int n = 2147483646;
//        byte[] test = new byte[n];
//        System.out.println(n);



//        printMemoryInfo();
//        byte[] test1 = new byte[2147483645];
//        System.out.println("-------------------------");
//        printMemoryInfo();


    }


    private static void printMemoryInfo() {
        System.out.println("-------------------");
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("最大内存: " + maxMemory / (1024 * 1024) + " MB");
        System.out.println("已分配内存: " + totalMemory / (1024 * 1024) + " MB");
        System.out.println("空闲内存: " + freeMemory / (1024 * 1024) + " MB");
        System.out.println("已使用内存: " + usedMemory / (1024 * 1024) + " MB");
    }

    public static void findMaxIntSize() {
        int low = 0;
        int high = Integer.MAX_VALUE; // 理论上数组的最大值为 Integer.MAX_VALUE
        System.out.println("Int理论值:"+high);
        int maxSize = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1; // 中间值，防止溢出
            int[] testArray = null; // 初始化数组引用为 null
            try {
                // 尝试分配数组
                testArray = new int[mid];
                // 如果分配成功，说明当前大小是可行的
                maxSize = mid; // 更新最大可行的数组大小
                low = mid + 1; // 继续尝试更大的数组
            } catch (OutOfMemoryError e) {
                // 如果内存不足，缩小查找范围
                high = mid - 1;
            } finally {
                // 清除对数组的引用，以便垃圾回收器可以回收内存
                testArray = null;
                // 可以选择在这里请求 GC，但这并不是强制性的
                // System.gc();
            }
        }

        System.out.println("Int实际值:" + maxSize);
    }


    public static void findMaxByteSize() {
        int low = 0;
        int high = Integer.MAX_VALUE; // 理论上数组的最大值为 Integer.MAX_VALUE
        System.out.println("Byte理论值:" + high);
        int maxSize = 0;

        int i = 1;
        while (low <= high) {
            int mid = (low + high) >>> 1; // 中间值，防止溢出
            if(i == 1){
                System.out.println(mid);
                i = i+1;
            }
//            System.out.println(mid);
            byte[] testArray = null; // 初始化数组引用为 null
            try {
                // 尝试分配数组
                testArray = new byte[mid]; // 使用 byte 数组
                // 如果分配成功，说明当前大小是可行的
                maxSize = mid; // 更新最大可行的数组大小
                low = mid + 1; // 继续尝试更大的数组
            } catch (OutOfMemoryError e) {
                // 如果内存不足，缩小查找范围
                high = mid - 1;
            } finally {
                // 清除对数组的引用，以便垃圾回收器可以回收内存
                testArray = null;
                // 可以选择在这里请求 GC，但这并不是强制性的
                // System.gc();
            }
        }

        System.out.println("Byte实际值:" + maxSize);
    }

}