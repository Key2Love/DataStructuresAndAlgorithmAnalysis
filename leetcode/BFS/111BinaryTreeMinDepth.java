package BFS;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: 给定一个二叉树，找出其最小深度。  最小深度是从根节点到最近叶子节点的最短路径上的节点数量。  说明: 叶子节点是指没有子节点的节点。
 * @author: Sunbuhui7
 * @create: 2020-04-20 11:05
 **/

class BinaryTreeMinDepth {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                root = queue.poll();
                if (root.left==null&&root.right==null){
                    return depth;
                }
                if (root.left!=null){
                    queue.offer(root.left);
                }
                if (root.right!=null){
                    queue.offer(root.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        //TreeNode one = new TreeNode(1);
        //TreeNode two = new TreeNode(2);

        three.left = nine;
        three.right = twenty;
        //nine.left = one;
        //nine.right = two;
        twenty.left = fifteen;
        twenty.right = seven;
        System.out.println(new BinaryTreeMinDepth().minDepth(three));

    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}