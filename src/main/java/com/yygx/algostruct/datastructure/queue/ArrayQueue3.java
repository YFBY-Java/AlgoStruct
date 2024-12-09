package com.yygx.algostruct.datastructure.queue;


import java.util.Iterator;

public class ArrayQueue3<E> implements Queue<E>,Iterable<E> {

    /**
     * 求模运算
     * 如果除数是2的n次方
     * 那么被除数的后n位即为余数
     */

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
        // 转成长整数求余 防止溢出
//        array[(int) (Integer.toUnsignedLong(tail) % array.length)] = value;
        // 减法优先级 大于 & (按位与)
        array[tail & array.length - 1] = value;
        tail++;   // tail自增超过int最大值会变为负数
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
//        E value = array[(int) (Integer.toUnsignedLong(head) % array.length)];
        E value = array[head & array.length - 1];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[head & array.length - 1];
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
                E value = array[pointer & array.length - 1];
                pointer++;
                return value;
            }
        };
    }
}