import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description: 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * @author: Sunbuhui7
 * @create: 2020-03-13 15:33
 **/

public class NoRepeatNum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int len = str.length();
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        for (int i=len-1;i>=0;i--){
            Integer num = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(set.contains(num)){
                continue;
            }else{
                set.add(num);
            }
        }
        for (Integer key : set){
            System.out.print(key);
        }
    }
}
