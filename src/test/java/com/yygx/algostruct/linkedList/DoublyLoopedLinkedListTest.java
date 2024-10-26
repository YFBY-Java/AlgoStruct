package com.yygx.algostruct.linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class DoublyLoopedLinkedListTest {

    private DoublyLoopedLinkedList doublyLoopedLinkedListUnderTest;

    @BeforeEach
    void setUp() {
        doublyLoopedLinkedListUnderTest = new DoublyLoopedLinkedList();
    }

    @Test
    void testIterator() {
        assertEquals(List.of(5,4,3,2,1).iterator(), doublyLoopedLinkedListUnderTest.iterator());
    }

    @Test
    void testAddFirst() {
        // Setup
        // Run the test
        doublyLoopedLinkedListUnderTest.addFirst(1);
        doublyLoopedLinkedListUnderTest.addFirst(2);
        doublyLoopedLinkedListUnderTest.addFirst(3);
        doublyLoopedLinkedListUnderTest.addFirst(4);
        assertIterableEquals(List.of(4,3,2,1), doublyLoopedLinkedListUnderTest);
        // Verify the results
    }


    @Test
    void testAddLast() {
        // Setup
        // Run the test
        doublyLoopedLinkedListUnderTest.addLast(1);
        doublyLoopedLinkedListUnderTest.addLast(2);
        doublyLoopedLinkedListUnderTest.addLast(3);
        doublyLoopedLinkedListUnderTest.addLast(4);
        // Verify the results
        assertIterableEquals(List.of(1,2,3,4), doublyLoopedLinkedListUnderTest);
    }


    @Test
    void testRemoveFirst() {
        // Setup
        // Run the test
        doublyLoopedLinkedListUnderTest.addLast(1);
        doublyLoopedLinkedListUnderTest.addLast(2);
        doublyLoopedLinkedListUnderTest.addLast(3);
        doublyLoopedLinkedListUnderTest.addLast(4);
        assertIterableEquals(List.of(1,2,3,4), doublyLoopedLinkedListUnderTest);
        doublyLoopedLinkedListUnderTest.removeFirst();
        // Verify the results
        assertIterableEquals(List.of(2,3,4), doublyLoopedLinkedListUnderTest);
    }



    @Test
    void testRemoveLast() {
        // Setup
        // Run the test
        doublyLoopedLinkedListUnderTest.addLast(1);
        doublyLoopedLinkedListUnderTest.addLast(2);
        doublyLoopedLinkedListUnderTest.addLast(3);
        doublyLoopedLinkedListUnderTest.addLast(4);
        assertIterableEquals(List.of(1,2,3,4), doublyLoopedLinkedListUnderTest);
        doublyLoopedLinkedListUnderTest.removeLast();
        // Verify the results
        assertIterableEquals(List.of(1,2,3), doublyLoopedLinkedListUnderTest);
    }


    @Test
    void testFindByValue() {
        // Setup
        // Run the test
        doublyLoopedLinkedListUnderTest.addLast(1);
        doublyLoopedLinkedListUnderTest.addLast(2);
        doublyLoopedLinkedListUnderTest.addLast(3);
        doublyLoopedLinkedListUnderTest.addLast(4);
        assertIterableEquals(List.of(1,2,3,4), doublyLoopedLinkedListUnderTest);
        int result = doublyLoopedLinkedListUnderTest.findByValue(3).value;
        // Verify the results
        assertEquals(3, result);

        Assertions.assertNull(doublyLoopedLinkedListUnderTest.findByValue(5));
    }


    @Test
    void testRemoveByValue() {
        // Setup
        // Run the test
        doublyLoopedLinkedListUnderTest.addLast(1);
        doublyLoopedLinkedListUnderTest.addLast(2);
        doublyLoopedLinkedListUnderTest.addLast(3);
        doublyLoopedLinkedListUnderTest.addLast(4);
        assertIterableEquals(List.of(1,2,3,4), doublyLoopedLinkedListUnderTest);
        doublyLoopedLinkedListUnderTest.removeByValue(3);
        // Verify the results
        assertIterableEquals(List.of(1,2,4), doublyLoopedLinkedListUnderTest);
    }
}
