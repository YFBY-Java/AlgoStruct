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


    private E[] array;
    private int head = 0;  // 头指针
    private int tail = 0;  // 尾指针

    @SuppressWarnings("all")   // 禁止警告产生
    public RingArrayQueue(int capacity){
        array = (E[]) new Object[capacity+1];
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
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int pointer = head;

            @Override
            public boolean hasNext() {
                return pointer != tail;
            }

            @Override
            public E next() {
                E value = array[pointer];
                pointer = (pointer+1) % array.length;
                return value;
            }
        };
    }
}