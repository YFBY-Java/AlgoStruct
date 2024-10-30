package com.yygx.algostruct.datastructure.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class DynamicArrayTest {

    @Test
    public void Test() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);

//        dynamicArray.forEach(System.out::println); // // 因为实参是一个匿名内部类并且重写的是函数式接口,所以可以简写成lambda函数的形式
//
//        for (Integer i : dynamicArray) {
//            System.out.println(i);
//        }
        dynamicArray.stream().forEach(System.out::println);
        System.out.println("-------------------------");
        dynamicArray.remove(2);
        dynamicArray.stream().forEach(System.out::println);

    }


    @Test
    public void dynamicArraysGrow(){
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 10; i++) {
            dynamicArray.addLast(i+1);
        }
        assertIterableEquals(List.of(1,2,3,4,5,6,7,8,9,10),dynamicArray);
    }

}