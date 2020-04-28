/**
 * @program: algorithm
 * @description: 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @author: Sunbuhui7
 * @create: 2020-04-14 16:49
 **/

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(temp);
        }

        return root;
    }

    private static void swap(TreeNode root) {
        while (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            swap(root.left);
            swap(root.right);
        }


    }

}
