package 双指针;


/**
 * @program: Algorithm
 * @description: 输入两个链表，找出它们的第一个公共节点。
 * @author: Sunbuhui7
 * @create: 2020-05-03 10:23
 **/

class 两个链表的第一个公共节点 {
    /**
     * 这个思路非常好，小+大，大+小。
     * 似乎比那个count计数，快慢指针好。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha!=hb){
            //这里有个小问题，不知道怎么解决。
            //为啥是ha!=null而不是ha.next!=null。
            //ha.next!=null的话，最后会一直死循环。
            //但是如果是ha!=null的话，最后就是两个null。
            ha = ha!=null?ha.next:headB;
            hb = hb!=null?hb.next:headA;
        }
        return ha;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


