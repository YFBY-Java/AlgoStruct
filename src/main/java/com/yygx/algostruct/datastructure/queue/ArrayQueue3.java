package com.yygx.algostruct.datastructure.queue;


import java.util.Iterator;

public class ArrayQueue3<E> implements Queue<E>,Iterable<E> {

    private final E[] array;
    private int head = 0;
    private int tail = 0;


    @SuppressWarnings("all")   // 禁止警告产生
    public ArrayQueue3(int capacity){
        array = (E[]) new Object[capacity];
    }


    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        array[tail % array.length] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E value = array[head % array.length];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[head % array.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        // 尾和头之间距离等于数组长度时，队列满
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int pointer = head;

            @Override
            public boolean hasNext() {
                return pointer != tail;
            }

            @Override
            public E next() {
                E value = array[pointer % array.length];
                pointer++;
                return value;
            }
        };
    }
}