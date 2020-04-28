import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-31 17:01
 **/

public class LinkedListDelete {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            head = head.next;
            return head;
        }
        ListNode pre = head;
        ListNode now = head.next;
        while(true){
            if(now.val==val){
                pre.next = now.next;
                break;
            }
            pre = now;
            now = now.next;
        }
        return head;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}