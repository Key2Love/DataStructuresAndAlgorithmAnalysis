package 树;

import java.util.Stack;

/**
 * @program: Algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-05-06 17:22
 **/

public class 二叉树的非递归遍历 {

    /**
     * 前序
     *
     * @param root
     */
    public void PreTraverse(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            //注意一定是right在前
            if (temp.right != null) stack.add(temp);
            if (temp.left != null) stack.add(temp);
        }
    }

    /**
     * 中序
     * 1.先将根节点入栈
     * 2.将当前节点的所有左孩子入栈，直到左孩子为空
     * 3.访问栈顶元素，如果栈顶元素存在右孩子，则继续第2步
     * 4.重复2、3步，直到栈为空并且所有的节点都被访问
     */
    public void InTraverse(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                //1.将根节点入栈
                //2.将所有左孩子入栈
                stack.add(temp);
                temp = temp.left;
            }
            //3.访问栈顶元素
            temp = stack.pop();
            System.out.println(temp.val);
            //4.如果栈顶元素存在右孩子，则将右孩子赋值给tmp，也就是将右孩子入栈
            if (temp.right != null) {
                //否则，将tmp置为null，表示下次要访问的是栈顶元素
                temp = temp.right;
            } else {
                temp = null;
            }
        }

    }

    public void PostTraverse(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack();
        //当前节点,之前的节点
        TreeNode temp = root, pre = null;
        while (temp != null || !stack.isEmpty()) {
            //1.将根节点及其左孩子入栈
            while (temp != null) {
                stack.add(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                //2.获取栈顶元素值
                temp = stack.peek();
                //3.没有右孩子，或者右孩子已经被访问过
                if (temp.right == null || pre == temp.right) {
                    temp = stack.pop();
                    //则可以访问栈顶元素
                    System.out.println(temp.val);
                    //标记上一次访问的节点
                    pre = temp;
                    temp = null;
                } else {
                    //4.存在没有被访问的右孩子
                    temp = temp.right;
                }
            }
        }
    }
}
