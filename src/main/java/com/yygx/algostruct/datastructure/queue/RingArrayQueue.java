package com.yygx.algostruct.datastructure.queue;


import java.util.Iterator;

/**
 * 环形数组实现队列
 * <p>
 *     环形数组优点：
 *     1.对比普通数组，起点和重点更为自由，不用考虑数据移动
 *     2.环意味着不存在越界问题
 *     3.数组性能更好
 *     4.环形数组比较适合实现有界队列，RingBuff
 * </p>
 */
public class RingArrayQueue<E> implements Queue<E>,Iterable<E> {
    @Override
    public boolean offer(E value) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
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
    public Iterator<E> iterator() {
        return null;
    }
}