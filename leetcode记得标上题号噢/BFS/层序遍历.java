package BFS;

import javax.swing.event.TreeWillExpandListener;
import java.util.*;

/**
 * @program: Algorithm
 * @description: 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @author: Sunbuhui7
 * @create: 2020-05-04 15:37
 **/

class LevelOrder {
    /**
     * 层序遍历，最后返回一个n*1的数组。
     *
     * @param root
     * @return
     */
    public int[] levelOrder1(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    /**
     * 层序遍历，使用一个嵌套数组
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
//            for (int i = 0; i <queue.size() ; i++) {
//            这一段很有意思，必须要for (int i = queue.size(); i >0 ; i--) 倒序遍历，因为上面正序遍历
//            每一次i<queue.size()，这个size是不停变化的，而一开始就声明i=queue.size(),值就初始化了不会变化。
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * 双栈法，奇数层从左到右，偶数层从右到左。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        Stack<TreeNode> A = new Stack<>();
        Stack<TreeNode> B = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        A.add(root);
        boolean flag = true;
        while (!A.isEmpty() || !B.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            if (flag) {
                for (int i = A.size(); i > 0; i--) {
                    TreeNode node = A.pop();
                    tmp.add(node.val);
                    if (node.left != null) B.add(node.left);
                    if (node.right != null) B.add(node.right);
                }
            } else {
                for (int i = B.size(); i > 0; i--) {
                    TreeNode node = B.pop();
                    tmp.add(node.val);
                    if (node.right != null) A.add(node.right);
                    if (node.left != null) A.add(node.left);
                }
            }
            res.add(tmp);
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i > 0; i--) {
            System.out.println(i);
        }
    }
}
