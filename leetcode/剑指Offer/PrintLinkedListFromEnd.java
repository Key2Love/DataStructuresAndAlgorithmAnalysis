package 剑指Offer;

import java.util.*;

/**
 * @program: algorithm
 * @description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @author: Sunbuhui7
 * @create: 2020-03-17 16:07
 **/

public class PrintLinkedListFromEnd {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    /**
     * 迭代写法。（递归本质是一种栈结构）
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ListNode tempNode = listNode;
        if(tempNode!=null){
            arrayList.add(0,tempNode.val);
            return printListFromTailToHead1(tempNode.next);
        }else{
            return arrayList;
        }
    }
    /**
     * 其中一种解法。首先如果要判断是不是空的，最好new一个中间变量。同时注意OJ平台里的import。
     * Stack判断是不是空的，用isEmpty()
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        //Collection里存的数据，不能是基本数据类型
        if (listNode==null){
            return null;
        }
        ArrayList<Integer> arrayIntList = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(listNode.val);
        while(listNode.next!=null){
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        /**
         *while(stack.hasNext()){
         实际并没有这样的写法。

         */
        while(!stack.isEmpty()){
            int a = stack.pop();
            arrayIntList.add(a);
        }
        return arrayIntList;
    }
}
class ListNode{
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
}
