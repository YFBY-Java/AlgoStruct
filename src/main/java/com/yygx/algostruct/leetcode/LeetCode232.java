package com.yygx.algostruct.leetcode;


import com.yygx.algostruct.datastructure.stack.ArrayStack;

/**
 * 232. 用栈实现队列<p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class LeetCode232 {


     ArrayStack<Integer> s1 = new ArrayStack<Integer>(100);
     ArrayStack<Integer> s2 = new ArrayStack<Integer>(100);



    public void push(int x) {  // 向队列尾添加
        s2.push(x);
    }

    public int pop() {   // 从队列头移除
        if(s1.isEmpty()){
            while (!s2.isEmpty()){  // 把s2所有元素移动到s1
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek() {  // 从队列头获取
        if(s1.isEmpty()){
            while (!s2.isEmpty()){  // 把s2所有元素移动到s1
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}