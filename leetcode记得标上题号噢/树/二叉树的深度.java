package 树;

/**
 * @program: Algorithm
 * @description: 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @author: Sunbuhui7
 * @create: 2020-05-02 20:20
 **/

class MaxTreeDepth {
    /**
     * 本来还想用account计数啥的，后来想到了递归。
     * 递归还是做的少，有时候写出来都不知道自己对不对。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
