import java.util.Scanner;

/**
 * @program: algorithm
 * @description: 题目描述 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。  输入描述:  输入一个整数（int类型）  输出描述:  这个数转换成2进制后，输出1的个数
 * @author: Sunbuhui7
 * @create: 2020-03-14 11:30
 **/

public class StoreOneNum {
    public static void main(String[] args){
        //5=101
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 1;
        //注意0
        while(num!=1){
            int remainer = num%2;
            if(remainer==1){
                count++;
            }
            num = num/2;
        }
        System.out.println(count);

    }
}
