import sun.reflect.generics.tree.Tree;

/**
 * @program: algorithm
 * @description: 树的两种遍历方式
 * @author: Sunbuhui7
 * @create: 2020-04-08 18:39
 **/

public class TravisTree {
    public static void main(String[] args) {
        TreeNode g=new TreeNode(7, null, null);
        TreeNode f = new TreeNode(6, null, null);
        TreeNode e = new TreeNode(5, null, null);
        TreeNode d = new TreeNode(4, null, null);
        TreeNode b = new TreeNode(2, d, e);
        TreeNode c = new TreeNode(3, f, g);
        TreeNode a = new TreeNode(1, b, c);


    }

    public void travisTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            travisTree(root.left);
            travisTree(root.right);
        }

    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        val = val;

    }
}
