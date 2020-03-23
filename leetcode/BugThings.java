import java.util.Scanner;

/**
 * @program: algorithm
 * @description: 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。
 * 如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * @author: Sunbuhui7
 * @create: 2020-03-14 12:33
 **/

public class BugThings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //有n钱
        int n = in.nextInt();
        //要买m个东西
        int m = in.nextInt();
        int[] f = new int[n + 1];

        Good[][] goods = new Good[60][3];
        for (int i = 0; i < m; i++) {
            int value = in.nextInt();
            int weight = in.nextInt();
            int sub = in.nextInt();
            Good tempGood = new Good(value, value * weight);
            if (sub == 0) {
                goods[i][0] = tempGood;
            } else {
                if (goods[sub - 1][1] == null) {
                    goods[sub - 1][1] = tempGood;
                } else {
                    goods[sub - 1][2] = tempGood;
                }
            }

        }
        //完成商品录入
        for (int i = 0; i < m; i++) {
            for (int j = n; j > 0 && goods[i][0] != null; j--) {
                Good a = goods[i][0];
                if (j >= a.v && (f[j - a.v] + a.vp > f[j])) {
                    f[j] = f[j - a.v] + a.vp;
                }
                if (goods[i][1] != null) {
                    Good b = goods[i][1];
                    if (j >= (a.v + b.v) && (f[j - a.v - b.v] + a.vp + b.vp > f[j])) {
                        f[j] = f[j - a.v - b.v] + a.vp + b.vp;
                    }
                    if (goods[i][2] != null) {
                        Good c = goods[i][2];
                        if (j >= (a.v + c.v) && (f[j - a.v - c.v] + a.vp + c.vp > f[j])) {
                            f[j] = f[j - a.v - c.v] + a.vp + c.vp;
                        }
                        if (j >= (a.v + b.v + c.v) && (f[j - a.v - b.v - c.v] + a.vp + b.vp + c.vp > f[j])) {
                            f[j] = f[j - a.v - b.v - c.v] + a.vp + b.vp + c.vp;
                        }

                    }
                }


            }

        }
        System.out.println(f[n]);
    }
}

class Good {
    int v;
    int vp;

    public Good(int v, int vp) {
        this.v = v;
        this.vp = vp;
    }
}


