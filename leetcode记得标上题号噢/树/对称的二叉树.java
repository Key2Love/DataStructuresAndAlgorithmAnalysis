package 树;

/**
 * @program: Algorithm
 * @description: 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @author: Sunbuhui7
 * @create: 2020-05-04 10:25
 **/

class IsSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return recur(root.left,root.right);
    }
    public boolean recur(TreeNode left,TreeNode right){
        if (left==null&&right==null) return true;
        if (left==null&&right!=null) return false;
        if (left!=null&&right==null) return false;
        return left.val==right.val&&recur(left.left,right.right)&&recur(left.right,right.left);
    }
}
