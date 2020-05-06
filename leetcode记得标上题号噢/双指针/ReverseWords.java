package 双指针;

/**
 * @program: Algorithm
 * @description: 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * @author: Sunbuhui7
 * @create: 2020-05-02 19:10
 **/

public class ReverseWords {
    /**
     * 这里算是对双指针的一个复习吧。
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s==null||s.length()==0){
            return s;
        }
        s.trim();
        int j = s.length()-1,i=j;
        StringBuffer sb = new StringBuffer();
        while (i>=0){
            while (i>=0&&s.charAt(i)!=' '){
                i--;
            }
            //注意substring这一块，需要注意substring(i+1,j+1)是从i+1到j这一段。
            sb.append(s.substring(i+1,j+1)+' ');
            while (i>=0&&s.charAt(i)==' '){
                i--;
            }
            j=i;
        }
        return sb.toString().trim();

    }
}
