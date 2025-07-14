package com.yygx.algostruct.datastructure.queue;

import java.util.Iterator;

/**
 * 基于循环数组实现双端队列
 * <p>
 * tail停下来的位置不存储，会浪费一个位置
 */
public class ArrayDeque<E> implements Deque<E>, Iterable {

    private int capacity;

    /*
    头尾指针
    head == tail 时，队列满

    向队列头添加元素，头指针向前移动，即 head-- ,再添加元素
    向队列尾添加元素，尾指针向后移动，即 tail++ ,再添加元素

    头部删除：先获取head位置的值，再让head++
    尾部删除：先获取tail位置的值，再让tail--

    队列满： head到tail距离为  数组长度-1 时，可以认为队列是满的
     */

    E[] array;
    int head;
    int tail;

    @SuppressWarnings("all")
    public ArrayDeque(E[] array, int capacity) {
        this.array = (E[]) new Object[capacity+1];
    }

    // 加一后越界处理
    static int inc(int i, int length) {
        // 加一之后越界了，将索引恢复为0
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    // 减一后越界处理
    static int dec(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;  // 因为有一个空位用来判断队列是否满
        }
        return i - 1;
    }


    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }


}