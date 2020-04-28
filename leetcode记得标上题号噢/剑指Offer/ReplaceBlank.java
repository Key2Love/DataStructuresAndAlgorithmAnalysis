package 剑指Offer;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author: Sunbuhui7
 * @create: 2020-03-16 15:57
 **/

public class ReplaceBlank {
    public static void main(String[] args) {
        //StringBuffer stringBuffer = new StringBuffer();
        //stringBuffer.append("abc def");
        //System.out.println(new ReplaceBlank().replaceSpace(stringBuffer));
        String[] a = new ReplaceBlank().testSplit("ssss ");
        System.out.println("1");
    }

    /**
     * 这里是原先的写法，split方法并不能保证如" abc"->"%20"。所以用例不通过。
     *
     * @param str
     * @return
     */
    public String replaceSpace1(StringBuffer str) {
        if (str.length() == 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        String tempStr = str.toString();
        //split这个方法如果没用找到匹配的，则该List只有str本身这一个元素
        String[] strList = tempStr.split(" ");
        if (strList.length == 1) {
            return strList[0];
        } else {
            for (int i = 0; i <= strList.length - 2; i++) {
                sb.append(strList[i] + " ");
            }
            sb.append(strList[strList.length - 1]);
            String finnalStr = sb.toString();
            return finnalStr;
        }


    }

    /**
     * 这是改进后的写法。
     * String中选择某一个字符最好用charAt，快速
     * 同时注意空字符串这个用例。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if (str.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        String tempStr = str.toString();
        //split这个方法如果没用找到匹配的，则该List只有str本身这一个元素
        for (int i = 0; i < tempStr.length(); i++) {
            if (tempStr.charAt(i) != ' ') {
                sb.append(tempStr.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        String finnalStr = sb.toString();
        return finnalStr;
    }

    public String[] testSplit(String it) {
        return it.split(" ");
    }
}
