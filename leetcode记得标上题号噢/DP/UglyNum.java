package DP;

/**
 * @program: Algorithm
 * @description: 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * @author: Sunbuhui7
 * @create: 2020-05-03 14:20
 **/

public class UglyNum {
    public int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int[] dp = new int[n];
        dp[0] = 1;
        //这个dp有点不常见，三指针dp，有点意思。
        for (int i = 0; i <n ; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (dp[i]==n2) a++;
            if (dp[i]==n3) b++;
            if (dp[i]==n5) c++;
        }
        return dp[n-1];
    }
}
