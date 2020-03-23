import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description: 题目描述 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述: 输入第一行为一个正整数n(1≤n≤1000),
 * 下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述: 数据输出n行，输出结果为按照字典序排列的字符串。
 * @author: Sunbuhui7
 * @create: 2020-03-14 10:14
 **/

public class DictionarySeqString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = Integer.parseInt(in.nextLine());
        String[] strList = new String[len];
        for (int i = 0; i < len; i++) {
            strList[i] = in.nextLine();
        }
        Arrays.sort(strList);
        for (String it : strList) {
            System.out.println(it);
        }
    }
}
