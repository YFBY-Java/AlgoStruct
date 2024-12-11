package com.yygx.algostruct.datastructure.stack;

import java.util.Iterator;
import java.util.StringJoiner;


/**
 * 基于链表实现栈
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E>,Iterable<E> {

    private int capacity;  // 容量
    private int size;  // 大小
    private Node<E> head = new Node<>(null,null);


    static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }


    /**
     * 向顶部添加元素
     * @param value 待压入值
     * @return
     */
    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        head.next = new Node<>(value,head.next);
        size++;
        return true;
    }

    /**
     * 弹出顶部元素
     * @return
     */
    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }

    /**
     * 返回顶部元素
     * @return
     */
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        return first.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> pointer = head.next;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public E next() {
                E value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }


    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (E e : this) {
            stringJoiner.add(e.toString());
        }
        return stringJoiner.toString();
    }
}