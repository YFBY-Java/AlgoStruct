package com.yygx.algostruct.datastructure.stack;


import java.util.Iterator;

/**
 * 数组实现栈
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E>,Iterable<E>{

    private E[] array;
    // 数组索引从0开始，每次添加元素后移动top，top在0时表示数组为空，top等于数组长度（即capacity）时说明数组满了
    private int top;


    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            return null;
        }
        return array[--top];
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int pointer = top;  // 栈是栈顶先出栈，从后往前

            @Override
            public boolean hasNext() {
                return pointer > 0;
            }

            @Override
            public E next() {
                return array[--pointer];
            }
        };
    }
}