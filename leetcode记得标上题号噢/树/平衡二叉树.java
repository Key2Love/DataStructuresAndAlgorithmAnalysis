package 树;

/**
 * @program: Algorithm
 * @description: 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @author: Sunbuhui7
 * @create: 2020-05-02 20:30
 **/

/**
 *
 */
class 平衡二叉树 {
    //最基本的递归写法。
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return Math.abs(Depth(root.left)-Depth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int Depth(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(Depth(root.left),Depth(root.right))+1;
    }
    public boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }
    public int recur(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = recur(root.left);
        if (left==-1) return -1;
        int right = recur(root.right);
        if (right==-1) return -1;
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}
