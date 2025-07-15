package com.yygx.algostruct.datastructure.queue;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayDequeTest {

    @Test
    public void offer(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(3);
        arrayDeque.offerFirst(1);
        arrayDeque.offerFirst(2);
        arrayDeque.offerLast(3);
        assertFalse(arrayDeque.offerLast(4));
        assertIterableEquals(List.of(2,1,3),arrayDeque);
    }

    @Test
    public void poll(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(7);
        assertTrue(arrayDeque.isEmpty());

        arrayDeque.offerLast(1);
        arrayDeque.offerLast(2);
        arrayDeque.offerLast(3);
        arrayDeque.offerFirst(4);
        arrayDeque.offerFirst(5);
        arrayDeque.offerFirst(6);
        arrayDeque.offerFirst(7);
        assertIterableEquals(List.of(7,6,5,4,1,2,3),arrayDeque);
        assertTrue(arrayDeque.isFull());

        assertEquals(7, arrayDeque.pollFirst());
        assertEquals(6, arrayDeque.pollFirst());
        assertEquals(5, arrayDeque.pollFirst());
        assertEquals(4, arrayDeque.pollFirst());
        assertIterableEquals(List.of(1,2,3),arrayDeque);
        assertFalse(arrayDeque.isFull());

    }

}