/**
 * @program: algorithm
 * @description: 输入两棵二叉树A和B，判断B是不是A的子结构。
 * (约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @author: Sunbuhui7
 * @create: 2020-04-14 15:45
 **/

public class SubTree {
    /**
     * 思路说明，将题目拆分成两个部分。首先边界值判断，A,B是否为空。然后判断A和B之间的关系，
     * 首先找到根节点和它相等的点，然后再遍历判断。
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null||A == null) {
            return false;
        }
        if (recur(A,B)){
            return true;
        }else {
            return isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }
    }
    public boolean recur(TreeNode A,TreeNode B){
        if (B ==null){
            return true;
        }
        if (A==null){
            return false;
        }
        if (A.val!=B.val){
            return false;
        }
        return recur(A.left, B.left)&&recur(A.right,B.right);
    }
    public void  travis(TreeNode root){
        if (root!=null){
            System.out.println(root);
            System.out.println(root.left);
            System.out.println(root.right);
        }

    }

    public static void main(String[] args) {

    }
}
