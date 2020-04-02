import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-24 20:43
 **/

public class Lottery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        double x = (double) n;
        double y = (double) m;
        System.out.println(recur(x, y));

    }

    private static double recur(double n, double m) {
        if (n > 1 && m >= 0) {
            double temp = n / (n + m);
            double meichoudao = m / (n + m - 1);
            return temp + (1 - temp) * meichoudao * recur(n, m - 2) + (1 - temp) * (1 - meichoudao) * recur(n - 1, m - 1);
        }
        //怎么计算小数问题
        return 0;
    }

}
