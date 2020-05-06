package DP;

import java.util.ArrayList;

/**
 * @program: Algorithm
 * @description: 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @author: Sunbuhui7
 * @create: 2020-05-03 17:30
 **/

class TranslateNumToStr {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        ArrayList<Integer> dp = new ArrayList<>(10);
        dp.add(1);
        dp.add(1);
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            if (tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0){
                dp.add(dp.get(i-1)+dp.get(i-2));
            }else {
                dp.add(dp.get(i-1));
            }
        }
        return dp.get(dp.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNumToStr().translateNum(26));
    }
}
