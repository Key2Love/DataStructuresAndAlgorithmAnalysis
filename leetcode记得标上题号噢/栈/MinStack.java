package 栈;

import java.util.Stack;

/**
 * @program: Algorithm
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @author: Sunbuhui7
 * @create: 2020-05-04 11:43
 **/

public class MinStack {
    Stack<Integer> A,B;
    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.isEmpty()||B.peek()>x){
            B.add(x);
        }

    }

    public void pop() {
        if (A.pop().equals(B.peek())) B.pop();

    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
