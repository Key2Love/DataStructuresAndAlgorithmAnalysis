package 剑指Offer;

import java.awt.*;
import java.util.HashMap;

/**
 * @program: algorithm
 * @description: 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * @author: Sunbuhui7
 * @create: 2020-03-20 14:41
 **/

public class Fib {
    private HashMap<Integer, Integer> hm = new HashMap<>();

    /**
     * 记忆性递归
     * @param n
     * @return
     */
    public int fib1(int n) {
        hm.put(0, 0);
        hm.put(1, 1);
        if (!hm.containsKey(n)) {
            hm.put(n, (fib1(n - 1) + fib1(n - 2)) % 1000000007);
        }
        return hm.get(n);
    }
    public int fib2(int n) {
        int a=0;
        int b=1;
        int sum=a+b;
        for(int i=0;i<n;i++){
            a = b;
            b = sum;
            sum = a+b;
        }
        if(a>=1000000007){
            a = a%1000000007 ;                                      ;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Fib().fib1(10));
    }
}
