package 剑指Offer;

import java.util.*;

/**
 * @program: algorithm
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: Sunbuhui7
 * @create: 2020-03-17 22:13
 **/

public class TwoStackMakeQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    /**
     * 自己实现的版本，并不是最优解。因为每一次都将stack完全输入输出。
     * @return
     */
    public int pop1() {
        while(!stack1.isEmpty()){
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int finnalResult = stack2.pop();
        while(!stack2.isEmpty()){
            int temp2 = stack2.pop();
            stack1.push(temp2);
        }
        return finnalResult;
    }

    public int popPerfect(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
