package com.yygx.algostruct.datastructure.stack;


/**
 * 栈（stack）是一种线性的数据结构，只能在其一端添加数据和移除数据。习惯来说，这一端称之为栈顶，
 * 另一端不能操作数据的称之为栈底
 */
public interface Stack<E> {

    /**
     * 向栈顶压入元素
     * @param value 待压入值
     * @return 压入成功返回true，否则返回false
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     * @return 栈非空返回栈顶元素，栈为空返回null
     */
    E pop();


    /**
     * 返回栈顶元素，不弹出
     * @return 栈非空返回栈顶元素，栈为空返回null
     */
    E peek();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     * @return
     */
    boolean isFull();
}
