package 树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: Algorithm
 * @description: 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * @author: Sunbuhui7
 * @create: 2020-05-07 00:32
 **/

public class 另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {

//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put()

        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (isSame(s,t)) return true;
        return isSubtree(s.left,t)||isSubtree(s.right,t);

    }
    boolean isSame(TreeNode s, TreeNode t){
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return  isSame(s.left,t.right)&&isSame(s.right,t.right);
    }
}
