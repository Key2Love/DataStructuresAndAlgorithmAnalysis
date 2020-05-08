package 回溯法;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @program: Algorithm
 * @description: 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @author: Sunbuhui7
 * @create: 2020-05-06 22:11
 **/

class 字符串的排列 {
    HashSet<String> res = new HashSet<>();
    String path = "";
    static int len;

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        len = s.length();
        recur(path, s);
        String[] end = res.toArray(new String[res.size()]);
        return end;
    }

    //路径，选择列表
    void recur(String temp, String s) {
        if (temp.length() == len) {
            if (!res.contains(temp)) {
                res.add(new String(temp));
            }
            return;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            String idx = s.substring(i, i + 1);
            temp = temp + idx;
            recur(temp, s.substring(0, i) + s.substring(i + 1, s.length()));
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        String a = "abc";
        String[] b = new 字符串的排列().permutation(a);
        for (String it :
                b) {
            System.out.println(it);
        }
    }
}
