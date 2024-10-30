package com.yygx.algostruct.datastructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer>{
    private int size = 0;  // 逻辑大小
    private int capacity = 8; // 容量
//    private int[] array = new int[capacity];
    private int[] array = {};  // 改进，初始时创建空数组，懒惰初始化


    public void addLast(int element) {
        add(size,element);
    }

    public void add(int index, int element) {

        checkAndGrow();  // 检查和扩容

        if(index < 0 || index > size){
            // 数组越界异常
            throw new RuntimeException("数组越界");
        }
        if (index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void checkAndGrow() {
        if(size == 0){
            array = new int[capacity];
        } else if(size == capacity){  // 容量检查
            // 数组容量满，进行扩容
            capacity += capacity>>1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }

    public int get(int index){
        if(index >0 && index<array.length-1){
            return array[index];
        }
        return -1;
    }


    /**
     * 函数式接口
     */
    public  void forEachTest(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 数组拷贝
     */
    public static void arrayCopy(int[] srcArray, int srcStart, int[] tarArray, int tarStart, int copyLength){
        for (int i = 0; i < copyLength; i++) {
            tarArray[tarStart+i] = srcArray[srcStart+i];
        }
    }


    /**
     * 迭代器遍历
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类，创建接口实现类
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() { // 有没有下一个元素
                return i<size;
            }

            @Override
            public Integer next() {  // 返回当前元素，并移动到下一个元素
                return array[i++];  // 先返回array[i]，再把i++
            }
        };
    }

    /**
     * Stream流遍历
     */
    public IntStream stream(){
        // 截取数组，拷贝从0到size，不包含size
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }



    public int remove(int index){
        int removed = array[index];
        if(index <size -1){
            arrayCopy(array,index+1,array,index,array.length-1-index);
        }
        size--;
        return removed;
    }





//    public static void ArrayTest(String[] args) {
//        int[] array = new int[]{1,2,3,4,5,6};
//        int[] newArray = new int[6];
//        arrayCopy(array,3,newArray,0,2);
//        System.out.println(Arrays.toString(newArray));
//    }


}