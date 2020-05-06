package 树;

/**
 * @program: Algorithm
 * @description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @author: Sunbuhui7
 * @create: 2020-05-05 18:09
 **/

class TurnTreeToLinkedList {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if (root==null) return root;
        recur(root);
        head.left = pre;
        pre.right = head;
        return head;

    }
    public void recur(Node cur){
        if (cur==null) return;
        recur(cur.left);
        if (pre!=null){
            pre.right=cur;
        }else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        recur(cur.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
