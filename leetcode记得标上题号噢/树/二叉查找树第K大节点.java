package 树;

/**
 * @program: Algorithm
 * @description: 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @author: Sunbuhui7
 * @create: 2020-05-03 09:09
 **/

class FindkthLargest {
    static int res,count;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if (root==null) return;
        dfs(root.right);
        if (count==0)return;
        //感觉其实还是写成count--比较好，不然容易出bug
        count--;
        if (count==0) res = root.val;
        dfs(root.left);
    }
}
