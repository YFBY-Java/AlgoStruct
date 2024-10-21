package com.yygx.algostruct.array;


import org.springframework.util.StopWatch;

public class MatrixArray {


    /**
     * 先遍历行，再遍历列
     * @param array
     * @param rows  行
     * @param columns  列
     */
    public static void rowColumns(int[][] array,int rows,int columns){
        long sum = 0L;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += array[i][j];
            }
        }
        System.out.println(sum);
    }


    /**
     * 先遍历列，再遍历行
     * @param array
     * @param rows
     * @param columns
     */
    public static void columnsRow(int[][] array,int rows,int columns){
        long sum = 0L;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                sum += array[j][i];
            }
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
        int row = 1_000_000;
        int columns = 14;
        int [][] array = new int[row][columns];
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("rowColumns");
        rowColumns(array,row,columns);
        stopWatch.stop();

        stopWatch.start("columnsRow");
        columnsRow(array,row,columns);
        stopWatch.stop();


        System.out.println(stopWatch.prettyPrint());
    }


    /*
    测试结果：
            0
            0
            StopWatch '': running time = 58436300 ns
            ---------------------------------------------
            ns         %     Task name
            ---------------------------------------------
            010657500  018%  rowColumns
            047778800  082%  columnsRow

     原因：
     先遍历行比先遍历列快
     因为 cpu读取内存后，会将其放入高速缓存（速度快）当中，如果后来的计算再用到此数据，在缓存中读取的话，就不必读内存了
     缓存的最小存储单位是缓存行（cache line），一般是64bytes，因此读取某个数据时也会读取其临近的数据，这就是所谓的空间局部性
     二维数组其实也是一维数组，是连续存储的，按照每一行拼接的顺序，所以先遍历行在遍历列符合内存存储格式，能够减少读取内存次数
     */
}