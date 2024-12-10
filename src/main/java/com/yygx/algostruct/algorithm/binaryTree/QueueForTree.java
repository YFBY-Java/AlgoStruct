package com.yygx.algostruct.algorithm.binaryTree;


import com.yygx.algostruct.datastructure.queue.LinkedListQueue;
import com.yygx.algostruct.datastructure.queue.TreeNode;

/**
 * 使用队列遍历二叉树
 */
public class QueueForTree {


    public static void main(String[] args) {
        // 根节点
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7))
        );

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);  // 将根节点放到队列
        while (!queue.isEmpty()){  // 队列非空继续循环
            // 从队列头部获取元素
            TreeNode poll = queue.poll();
            System.out.println(poll);  // 打印当前元素
            if (poll.left != null){
                queue.offer(poll.left);

            }
            if (poll.right != null){
                queue.offer(poll.right);
            }
        }
    }
}