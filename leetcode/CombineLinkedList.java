/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-04-14 14:50
 **/

public class CombineLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0), cur = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return fakeHead.next;
    }
    /**
     * 练习，链表的两种插入方式。一：尾插入
     */
    public ListNode headInsert(ListNode l1){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        cur.next = l1;
        cur = cur.next;
        return cur;
    }
    /**
     * 头插入
     */
    public ListNode tailInsert(ListNode l2){
        ListNode head = null;
        l2.next = head;
        head = l2;
        return head;
    }
}