package com.yygx.algostruct.datastructure.queue;


import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E>,Iterable<E> {



    private E[] array;
    private int head = 0;  // 头指针
    private int tail = 0;  // 尾指针
    private int size = 0;   // 元素个数，有元素个数就不用再保留一个指针

    @SuppressWarnings("all")   // 禁止警告产生
    public ArrayQueue(int capacity){
        array = (E[]) new Object[capacity];
    }


    /**
     * 向队列的尾部新增元素
     * @param value 待插入值
     * @return
     */
    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        array[tail] = value;  // 在尾部添加元素
        tail = (tail + 1) %  array.length;  // 移动指针
        size++;
        return true;
    }


    /**
     * 从队列头部移除元素
     * @return
     */
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        size--;
        return value;
    }


    /**
     * 查看队首元素
     * @return
     */
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int pointer = head;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E value = array[pointer];
                pointer = (pointer + 1) % array.length;
                count++;
                return value;
            }
        };
    }
}