package com.yygx.algostruct.datastructure.queue;


import cn.hutool.core.lang.tree.Node;

import java.util.Iterator;

/**
 * 基于双向环形链表实现
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E>{

    @Override
    public boolean offerFirst(E e) {
        if(isFull()){
            return false;
        }
        Node<E> node = new Node<>(sentinel,e,sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }
        Node<E> node = new Node<>(sentinel.prev,e,sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> removed = sentinel.next;
        removed.next.prev = sentinel;
        sentinel.next = removed.next;
        size--;
        return removed.vlaue;
    }

    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        Node<E> removed = sentinel.prev;
        removed.prev.next = sentinel;
        sentinel.prev = removed.prev;
        size--;
        return removed.vlaue;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()){
            return null;
        }
        return sentinel.next.vlaue;
    }

    @Override
    public E peekLast() {
        if(isEmpty()){
            return null;
        }
        return sentinel.prev.vlaue;
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
            // 指针
            Node<E> point = sentinel.next;  // 从第一个元素开始遍历

            @Override
            public boolean hasNext() {
                // 没有遇到哨兵的时候说明还没结束
                return point != sentinel;
            }

            @Override
            public E next() {
                E vlaue = point.vlaue;
                point = point.next;
                return vlaue;
            }
        };
    }

    static class Node<E> {
        Node<E> prev;
        E vlaue;
        Node<E> next;

        public Node(Node<E> prev,E vlaue,Node<E> next){
            this.prev = prev;
            this.vlaue = vlaue;
            this.next = next;
        }
    }

    int capacity;  // 容量
    int size; // 队列中的元素个数
    // 哨兵节点
    Node<E> sentinel = new Node<>(null,null,null);

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }



}