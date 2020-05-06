package 回溯法;


import java.util.LinkedList;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @author: Sunbuhui7
 * @create: 2020-05-05 13:24
 **/

class PathSum {
//    最后的返回结果
    List<List<Integer>> res = new LinkedList<>();
//    每次路径的保存结果
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        递归函数
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar) {
//        递归的终止条件
        if (root == null) return;
//        做选择
//        将路径从选择列表移除，在这个里面就是tar -= val
//        路径.add（选择）
        path.add(root.val);
        tar -= root.val;
//        当路径满足条件之后,结果列表add(路径)
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
//        递归函数
        recur(root.left, tar);
        recur(root.right, tar);
//        撤销该选择
        path.removeLast();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
