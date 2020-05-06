package 树;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @author: Sunbuhui7
 * @create: 2020-05-04 17:08
 **/

class PathSum {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,sum);
        return res;
    }
    public void recur(TreeNode root,int tar){
        if (root==null) return;
        path.add(root.val);
        tar -= root.val;
        //值得注意的是，记录路径时若直接执行 res.append(path) ，则是将 path 对象加入了 res ；
        //后续 path 改变时， res 中的 path 对象也会随之改变。
        //正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res 。

        if (tar==0&&root.left==null&&root.right==null){
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        recur(root.left,tar);
        recur(root.right,tar);
        path.removeLast();
    }


}
