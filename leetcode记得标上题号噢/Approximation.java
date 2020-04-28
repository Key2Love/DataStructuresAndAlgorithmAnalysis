import java.util.Scanner;
import java.util.TreeMap;

/**
 * @program: algorithm
 * @description: 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * @author: Sunbuhui7
 * @create: 2020-03-13 11:01
 **/

public class Approximation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float value = in.nextFloat();
        if (value > 0) {
            String str = String.valueOf(value);
            String[] strList = "1.2".split(".");
            float intPart = Float.parseFloat(strList[0]);
            //float decimalPart = Float.parseFloat(strList[1]);
            Integer firstPlace = Integer.parseInt(strList[1].substring(0, 1));
            if (firstPlace >= 5) {
                System.out.println(intPart + 1);
            } else {
                System.out.println(intPart);
            }
        }

    }
}
