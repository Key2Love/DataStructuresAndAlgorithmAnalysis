package DP;

/**
 * @program: algorithm
 * @description: 硬币。
 * 给定数量不限的硬币，币值为25分、10分、5分和1分，
 * 编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 * @author: Sunbuhui7
 * @create: 2020-04-23 09:23
 **/

public class WaysToChange {
    public static int[] unit = {1, 5, 10, 25};

    public int waysToChange(int n) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        //这样的写法规定了好了顺序，不会出现1+5和5+1都计算的情况。
        //for (int i = 0; i < 4; i++)是这一块的重点。
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= unit[i]) {
                    //避免大数问题
                    ways[j] = (ways[j] + ways[j - unit[i]]) % 1000000007;
                }
            }
        }
        return ways[n];


    }

    public static void main(String[] args) {
        System.out.println(new WaysToChange().waysToChange(9));

    }
}
