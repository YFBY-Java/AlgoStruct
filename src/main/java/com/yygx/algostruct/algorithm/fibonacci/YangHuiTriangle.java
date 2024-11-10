package com.yygx.algostruct.algorithm.fibonacci;


/**
 * 杨辉三角
 */
public class YangHuiTriangle {

    private static int element(int i, int j) {
        if (j == 0 || i == j) return 1;
        return element(i - 1, j - 1) + element(i - 1, j);
    }


    /**
     * 二维数组记忆法
     * @param triangle
     * @param i
     * @param j
     * @return
     */
    private static int elementPro(int[][] triangle, int i, int j) {
        if(triangle[i][j] > 0) return triangle[i][j];
        if (j == 0 || i == j) {
            triangle[i][j] = 1;
            return 1;
        }
        triangle[i][j] = elementPro(triangle, i - 1, j - 1) + elementPro(triangle, i - 1, j);
        return triangle[i][j];
    }


    /**
     * 一维数组记忆法
     * 生成每一行的数据
     */
    private static void createRow(int[] row,int i){
        if(i == 0) {
            row[0] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            row[j] = row[j] + row[j-1];
        }
    }



    private static void printPro(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", elementPro(triangle, i, j));
            }
            System.out.println();
        }
    }

    /**
     * 一维数组记忆法打印
     * @param n
     */
    private static void printRow(int n) {
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            createRow(row,i);
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", row[j]);
            }
            System.out.println();
        }
    }


    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }

    private static void printSpace(int n, int i) {
        int num = (n - 1 - i) * 2;
        for (int i1 = 0; i1 < num; i1++) {
            System.out.print(" ");
        }
    }


    public static void main(String[] args) {
//        System.out.println(element(4, 2));
//        print(5);
//        printPro(10);
        printRow(10);
    }
}