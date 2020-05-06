package 链表;

/**
 * @program: Algorithm
 * @description: 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * @author: Sunbuhui7
 * @create: 2020-05-05 16:31
 **/

class CopyComplexLinkedList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            //插入clone节点
            Node clone = new Node(node.val, node.next, null);
            Node temp = node.next;
            node.next = clone;
            node = temp;
        }
        //上面已经插入了节点
        node = head;
        while (node!=null){
            //还原random节点
            //为什么不是直接node.random呢,有两个点需要注意.
            //一:如果直接是node.random的话,就是浅拷贝.
            //二:为什么要判断node.random==null?
            //想象一下node.random.next.如果node.random是null的话出nullpointer错误.
            node.next.random = node.random==null?null:node.random.next;
            node = node.next.next;
        }
        node = head;
        Node clonehead = node.next;
        //这一段就是将指针重连接的过程
        while (node.next!=null){
            //只是为了保留下一个指针.
            Node temp = node.next; //fake1
            //使当前节点的next指向跳过clonenode的下一个节点.
            node.next = node.next.next; //1.next = 2
            node =temp;//node = fake1
        }
        return clonehead;

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
}
