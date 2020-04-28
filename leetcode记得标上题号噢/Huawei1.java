/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-18 19:01
 **/

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;
public class Huawei1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        Scanner in = new Scanner(System.in);
        String tempStr = in.nextLine();
        String[] strList = tempStr.split(" ");
        String[] ipOne  = strList[0].split("\\.");
        String[] ipTwo = strList[1].split("\\.");
        String[] mask = strList[2].split("\\.");
        Huawei1 hw = new Huawei1();
        String ip1 = hw.test(ipOne);
        String ip2 = hw.test(ipTwo);
        String finnalMask = hw.test(mask);
        String finnalip1 = hw.plus(ip1,finnalMask);
        String finnalip2 = hw.plus(ip2,finnalMask);
        if (finnalip1.equals(finnalip2)){
            sb.append(1+" ");
            sb.append(finnalip1);
            String finnal = sb.toString();
            System.out.println(finnal);
        }else{
            sb.append(0+" ");
            sb.append(finnalip1);
            String finnal = sb.toString();
            System.out.println(finnal);
        }

    }
    public String test(String[] ip){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<4;i++){
            Integer a =Integer.parseInt(ip[i]);
            String temp = Integer.toBinaryString(Integer.parseInt(ip[i]));
            for (int j = 0; j <8-temp.length() ; j++) {
                sb.append(0);
            }
            sb.append(temp);
        }
        String finnal = sb.toString();
        return finnal;
    }

    public String plus(String a,String b){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<32;i++){
            int ip1 = Integer.parseInt(String.valueOf(a.charAt(i)));
            int ip2 = Integer.parseInt(String.valueOf(b.charAt(i)));
            if(ip1+ip2==2){
                sb.append(1);
            }else{
                sb.append(0);
            }
        }
        String finnal = sb.toString();
        StringBuffer sbb = new StringBuffer();
        Byte[] byteList = new Byte[4];
        for (int i = 0; i <4; i++) {
            String tempStr = finnal.substring(0+i*8,8+i*8);
            int temp = new Huawei1().returnInt(tempStr);
            sbb.append(temp+".");
        }
        String f = sbb.toString();
        f = f.substring(0,f.length()-1);

        return f;
    }

    public Integer returnInt(String a){
        int total = 0;
        for (int i = 7; i >=0 ; i--) {
            int temp = Integer.parseInt(String.valueOf(a.charAt(i)));
            int pow = (int)Math.pow(2,7-i);
            total += pow*temp;
        }
        return total;
    }
}