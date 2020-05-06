package 位运算;

/**
 * @program: Algorithm
 * @description: 求 1+2+...+n ，
 * 要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 * @author: Sunbuhui7
 * @create: 2020-05-02 11:35
 **/

public class Sum1toN {
    int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
