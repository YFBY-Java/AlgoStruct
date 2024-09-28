package com.yygx.algostruct.util;

import java.util.Random;

/**
 * <p>
 * 注释：工具类
 * </p>
 * Since: 2024/9/28 <p>
 * Author: <a href="https://github.com/YFBY-Java" target="_blank">吟风抱月</a>
 */
public final class Utils {


    /**
     * 生成指定数量的随机数
     * @param size 随机数数量
     * @return 随机数数组
     */
    public static int[] generateRandomArray(int size){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(); // 生成随机数
        }
        return array;
    }
}
