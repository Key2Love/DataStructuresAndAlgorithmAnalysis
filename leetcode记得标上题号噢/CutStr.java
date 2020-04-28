import java.util.HashMap;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description: •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组； •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * @author: Sunbuhui7
 * @create: 2020-03-12 18:15
 **/

public class CutStr {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            StringBuffer sb = new StringBuffer();
            sb.append(str);
            int len = str.length();
            int remainer = len%8;
            if(len==0){
                continue;
            }else {
                for(int i=1;i<=8-remainer;i++){
                    sb.append(0);
                }
            }
            String finnalStr = sb.toString();
            while(finnalStr.length()>0){
                String cutStr = finnalStr.substring(0,8);
                System.out.println(cutStr);
            }
        }

    }
}
