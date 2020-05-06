package DP;

/**
 * @program: Algorithm
 * @description: 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。   
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * @author: Sunbuhui7
 * @create: 2020-05-02 17:07
 **/

public class NDicePoints {
    public double[] twoSum(int n) {
        //用于保存该位置出现的次数。
        int[][] dp = new int[n+1][6*n+1];
        //浮点数用double最好
        for (int i = 1; i <=6 ; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <n+1 ; i++) {
            for (int j = i; j <6*n+1 ; j++) {
                //动态方程。这个K<=6不难理解但是k<=j咋理解？
                //懂了，因为它是dp[骰子个数][组成的数字大小，总不能超过数字大小吧？]
                //不是，这个真的有用吗？
                for (int k = 1; k <=6&&k<j ; k++) {
                   dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        double total = Math.pow((double)6,(double)n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)dp[n][i])/total;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new NDicePoints().twoSum(6));
    }
}
