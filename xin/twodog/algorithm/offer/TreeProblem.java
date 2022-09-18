package xin.twodog.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 二叉树的层序遍历
 * 记录孩子，并放入队列。
 * 出队列，同时记录孩子，并放入队列。
 * <p>
 * <p>
 * 1. 空的特殊判断下，返回空数组
 * 2. 用队列存节点
 * 3. 循环条件是队列里面节点为空
 * 4. poll 一个节点出来做两个操作，统计值，子节点入队。
 */
public class TreeProblem {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        //Use the queue to store the parent node
        if (root == null) return new int[]{};
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.poll();
            list.add(treeNode.val);
            if (treeNode.left != null) treeNodes.add(treeNode.left);
            if (treeNode.right != null) treeNodes.add(treeNode.right);
        }
        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        Queue<TreeNode> treeNodesQueue = new LinkedList<>();
        if (root == null) return new ArrayList<>();
        treeNodesQueue.offer(root);
        while (!treeNodesQueue.isEmpty()) {
            int size = treeNodesQueue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode treeNode = treeNodesQueue.poll();

                temp.add(treeNode.val);

                if (treeNode.left != null) treeNodesQueue.add(treeNode.left);
                if (treeNode.right != null) treeNodesQueue.add(treeNode.right);
            }
            listList.add(temp);

        }
        return listList;
    }

    /**
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        Queue<TreeNode> treeNodesQueue = new LinkedList<>();
        if (root == null) return new ArrayList<>();
        treeNodesQueue.offer(root);
        int flag = 0;
        while (!treeNodesQueue.isEmpty()) {
            int size = treeNodesQueue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode treeNode = treeNodesQueue.poll();

                temp.add(treeNode.val);

                if (treeNode.left != null) treeNodesQueue.add(treeNode.left);
                if (treeNode.right != null) treeNodesQueue.add(treeNode.right);

            }
            if (flag % 2 == 1) {
                List<Integer> list = new ArrayList<>();
                for (int i = temp.size() - 1; i >= 0; i--) {
                    list.add(temp.get(i));
                }
                temp = list;
            }
            flag++;
            listList.add(temp);

        }
        return listList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
