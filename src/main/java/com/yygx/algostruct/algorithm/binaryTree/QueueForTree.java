package com.yygx.algostruct.algorithm.binaryTree;


import com.yygx.algostruct.datastructure.queue.LinkedListQueue;
import com.yygx.algostruct.datastructure.queue.TreeNode;

/**
 * 使用队列遍历二叉树
 */
public class QueueForTree {


    public static void main(String[] args) {
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
//        traverseTree();
        traverseTreeLevel(root);

    }

    private static void traverseTree(TreeNode root) {
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


    /**
     * 分层遍历二叉树
     */
    private static void traverseTreeLevel(TreeNode root) {
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);  // 将根节点放到队列
        int currentNode = 1;
        while (!queue.isEmpty()){  // 队列非空继续循环
            int nextNode = 0;
            for (int i = 0; i < currentNode; i++) {
                // 从队列头部获取元素
                TreeNode poll = queue.poll();
                System.out.print(poll+" ");  // 打印当前元素
                if (poll.left != null){
                    queue.offer(poll.left);
                    nextNode++;
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                    nextNode++;
                }
            }
            currentNode = nextNode;
            System.out.println();
        }
    }
}