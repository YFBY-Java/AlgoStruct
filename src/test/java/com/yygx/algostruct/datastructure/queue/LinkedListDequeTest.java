package com.yygx.algostruct.datastructure.queue;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListDequeTest {


    @Test
    public void offer(){
        LinkedListDeque<Integer> queue = new LinkedListDeque<>(5);
        queue.offerFirst(1);
        queue.offerFirst(2);
        queue.offerFirst(3);
        queue.offerLast(4);
        queue.offerLast(5);
        assertFalse(queue.offerFirst(6));
        assertIterableEquals(List.of(3,2,1,4,5),queue);
    }

    @Test
    public void poll(){
        LinkedListDeque<Integer> queue = new LinkedListDeque<>(5);
        queue.offerLast(1);
        queue.offerLast(2);
        queue.offerLast(3);
        queue.offerLast(4);
        queue.offerLast(5);

        assertEquals(1,queue.pollFirst());
        assertEquals(2,queue.pollFirst());
        assertEquals(5,queue.pollLast());
        assertEquals(4,queue.pollLast());
        assertEquals(3,queue.pollLast());
        assertNull(queue.pollLast());
        assertTrue(queue.isEmpty());
    }


}