/**
 * @program: algorithm
 * @description: 反转单链表
 * @author: Sunbuhui7
 * @create: 2020-04-14 17:46
 **/

public class ReverseLinkedList {
    public Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 子链表
        Node newList = reverseLinkedList(head.next);
        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        Node t1  = head.next;
        // 让 2 的 next 指向 2
        t1.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        return newList;

    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        Node finnal = new ReverseLinkedList().reverseLinkedList(one);
        System.out.println(finnal.val);
    }
}

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        ;
    }
