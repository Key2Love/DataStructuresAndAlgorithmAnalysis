package 位运算;

/**
 * @program: Algorithm
 * @description: 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @author: Sunbuhui7
 * @create: 2020-05-02 11:24
 **/

class AddNoSign {
    public int add(int a,int b){
        while (b!=0){
            int c = (a&b)<<1;
            a ^= b;//这一块原来写错了，其实只有b
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = -1;
        int b = -1;
        System.out.println(new AddNoSign().add(1,2));
    }
}
