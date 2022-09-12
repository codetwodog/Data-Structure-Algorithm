package xin.twodog.algorithm;


/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：
 * 1. 根据前序和中序，找到左右子树并递归
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RebuildBinaryTree {
    /*    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            List<Integer> preList = new LinkedList<>();
            List<Integer> inList
        }*/
    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int in[] = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reBuildBinaryTree(pre, in);
        preOrder(root);

    }

    public static TreeNode reBuildBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        return reBuildBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 先序遍历方法验证结果
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            if (root.left != null) {
                preOrder(root.left);
            }
            if (root.right != null) {
                preOrder(root.right);
            }
        }
    }

    public static TreeNode reBuildBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        int rootValue = pre[preStart]; //根的位置
        TreeNode root = new TreeNode(rootValue); //为根赋值
        root.left = root.right = null; //把跟都置为nul
        if (preStart == preEnd) {
            if (inStart == inEnd && pre[preStart] == in[inStart]) {
                return root;
            } else {
                System.err.println("Invalid input");
            }
        }
        //在中序遍历中找到根节点
        int rootInorder = inStart;
        while (rootInorder <= inEnd && in[rootInorder] != rootValue)
            rootInorder++;

        if (rootInorder == inEnd && in[rootInorder] != rootValue) {
            System.err.println("Invalid input.");
        }
        int leftLength = rootInorder - inStart;
        int leftPreorderEnd = preStart + leftLength;
        int rightLength = inEnd - rootInorder; //右子树的长度
        if (leftLength > 0) {
            // 构建左子树
            root.left = reBuildBinaryTree(pre, preStart + 1, leftPreorderEnd, in, inStart, rootInorder - 1);
        }
        if (rightLength > 0){
            root.right = reBuildBinaryTree(pre, leftPreorderEnd + 1, preEnd, in, rootInorder + 1, inEnd);
        }
            return root;
    }

}


