package com.yygx.algostruct.datastructure.queue;


import java.util.Iterator;

/**
 * 单向环形带哨兵链表实现队列
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E>,Iterable<E>{



    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size;  // 节点数
    private int capacity = Integer.MAX_VALUE;  // 队列容量


    Node<E> head = new Node<>(null,null);  // 头节点，哨兵节点
    Node<E> tail = head;  // 尾节点，即队尾

    public LinkedListQueue() {
        tail.next = head;
    }

    public LinkedListQueue(int capacity) {
        tail.next = head;
        this.capacity = capacity;
    }

    @Override
    public boolean offer(E value) {
        if(isFull()) return false;
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        if(first == tail){  // 删除尾节点要把尾指针也指向头节点
            tail = head;
        }
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if(isEmpty()) return null;
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
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
                return pointer != head;
            }

            @Override
            public E next() {
                E value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }
}