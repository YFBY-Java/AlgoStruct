package com.yygx.algostruct.written;


// 去哪


public class WrittenTestPreparation {

    /**
     * 回收废旧残疾车
     * <br/>
     * 2023年开始，北京各个街道都在回收淘汰废旧3轮、4轮残疾电动车。<br/>
     * 无论是3轮电动车还是4轮电动车都需要有1个方向盘来控制方向，<br/>
     * 其中方向盘和轮胎需要单独拆卸下来进行回收。<br/>
     * <br/>
     * 假设海淀街道共回收方向盘 x 个，轮胎 y 条，<br/>
     * 求海淀街道回收3轮电动车多少辆。<br/>
     * 如果无法得到有效的3轮电动车数量，则返回 -1。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入：x = 10, y = 35<br/>
     * 输出：5<br/>
     * 解释：10 辆车中，5 辆是三轮车(5*3=15条轮胎)，5 辆是四轮车(5*4=20条轮胎)，总共 35 条轮胎。<br/>
     * <br/>
     * 示例 2：<br/>
     * 输入：x = 5, y = 18<br/>
     * 输出：-1<br/>
     * 解释：不存在满足条件的三轮车和四轮车组合。<br/>
     */
    public int tricycle(int x, int y) {
        // x 为 方向盘数量，y为轮子数量
        // 鸡兔同笼问题
        // 三轮车数量 + 四轮车数量 = x , 设 a 为三轮车数量，b为 四轮车数量  a + b = x
        // 3a + 4b = y  所以  b = (y - 3a) / 4
        // 所以 a + (y - 3a)/4 = x
        // a/4 = x - y/4
        int a = 4 * x - y;
        int b = y - 3 * x;
        // a 和 b 都是正整数，a + b = x
        if (a >= 0 && b >= 0 && a % 1 == 0 && b % 1 == 0 && a + b == x) {
            return a;
        } else {
            return -1;
        }
    }


    /**
     * 求二维矩阵中子矩阵相加和的最大值
     * <br/>
     * 给定一个 m × n 的二维整数矩阵（包含正数、负数和零），<br/>
     * 找出其所有子矩阵中元素和的最大值。<br/>
     * <br/>
     * 子矩阵定义：原矩阵中任意连续行和连续列构成的矩形区域。<br/>
     * 求和规则：计算子矩阵内所有元素的总和。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入：matrix = [[1,-2,-1,4],[1,3,-2,1],[-1,1,5,-3]]<br/>
     * 输出：9<br/>
     * 解释：最大子矩阵和由矩阵 [[3,-2],[1,5]] 构成，总和为 3+(-2)+1+5=7（根据具体矩阵调整）。<br/>
     * <br/>
     * 示例 2：<br/>
     * 输入：matrix = [[-1,-2],[-3,-4]]<br/>
     * 输出：-1<br/>
     * 解释：最大子矩阵和为 -1，由单个元素 -1 构成。<br/>
     */
    public int[] maxSubMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSum = Integer.MIN_VALUE; // 处理全负数情况
        int[] result = new int[4]; // 存储 r1, c1, r2, c2

        // 枚举左上角
        for (int r1 = 0; r1 < m; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                // 枚举右下角
                for (int r2 = r1; r2 < m; r2++) {
                    for (int c2 = c1; c2 < n; c2++) {
                        int sum = 0;
                        // 计算当前子矩阵和
                        for (int i = r1; i <= r2; i++) {
                            for (int j = c1; j <= c2; j++) {
                                sum += matrix[i][j];
                            }
                        }
                        // 更新最大和及边界
                        if (sum > maxSum) {
                            maxSum = sum;
                            result = new int[]{r1,c1,r2,c2};
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WrittenTestPreparation writtenTestPreparation = new WrittenTestPreparation();
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        writtenTestPreparation.maxSubMatrix(array);
    }


}