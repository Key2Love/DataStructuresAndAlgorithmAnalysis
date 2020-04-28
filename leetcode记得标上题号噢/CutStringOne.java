import java.util.Comparator;

/**
 * @program: algorithm
 * @description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Sunbuhui7
 * @create: 2020-03-26 09:36
 **/

public class CutStringOne {
    public int cuttingRope(int n) {
        if (n == 1) {
            return 1;
        }
        //这里动态规划方程的建立需要考虑。由于最大的乘积其实是两段绳子各自最大的乘积。
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        int max = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                int temp = Math.max(dp[j] * dp[i - j], dp[i - j] * j);
                if (temp > max) {
                    max = temp;
                    dp[i] = temp;
                }
            }
        }
        return max;


    }

    public static void main(String[] args) {
        System.out.println(new CutStringOne().cuttingRope(10));
    }
}
