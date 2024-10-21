package com.yygx.algostruct.datastructure.linkedList;


import com.yygx.algostruct.linkedList.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LinkedListTest {



    @Test
    public void test1(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        singlyLinkedList.addFirst(5);
        singlyLinkedList.addFirst(6);
        singlyLinkedList.addFirst(7);
        singlyLinkedList.addFirst(8);
        singlyLinkedList.addFirst(9);

//        linkedList.loopWhile(System.out::println);
        singlyLinkedList.loopFor(System.out::println);
    }



    @Test
    public void test2(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }

    @Test
    public void test3(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.addLast(5);
        Assertions.assertIterableEquals(List.of(1,2,3,4,5), singlyLinkedList);
    }



}