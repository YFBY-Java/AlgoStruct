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
    public ArrayDeque(int capacity) {
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
        if(isFull()){
            return false;
        }
        // 先head--，再添加元素
        head = dec(head, array.length);
        array[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }
        // 先在tail添加元素，再tail++
        array[tail] = e;
        tail = inc(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        E e = array[head];
        array[head] = null;  // head GC
        head = inc(head,array.length);
        return e;
    }

    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        tail = dec(tail,array.length);
        E e = array[tail];
        array[tail] = null; // help GC
        return e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()){
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
        if(isEmpty()){
            return null;
        }
        return array[dec(tail,array.length)];  // tail位置不存元素
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        // 尾指针>头指针 时，  尾 - 头 = 数组长度 - 1
        // 尾指针<头指针 时，  头 - 尾 = 1   数组满
        if(tail > head){
            return tail - head == array.length - 1;
        }else if(tail < head){
            return head - tail == 1;
        }
        return false;  // head == tail 表示数组为空
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int point = head;
            @Override
            public boolean hasNext() {
                return point != tail;
            }

            @Override
            public E next() {
                E e = array[point];
                point = inc(point,array.length);
                return e;
            }
        };
    }


}