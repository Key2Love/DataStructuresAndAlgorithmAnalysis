//package 栈;
//
//import java.util.Scanner;
//
///**
// * 输入一个字符串，根据规则判断并输出对应格式的值，
// * <p>
// * 规则如下：如果字符串是空格开头，则移除空格后，遍历字符串直到最后一个非数字字符。然后输出这个整型数值。
// * <p>
// * 输入样例：
// * <p>
// * case 1：输入："    1234"
// * <p>
// * case 2：输入："xes    1234"
// * <p>
// * case 3：输入："1234xes     xes"
// * <p>
// * case 4：输入："1234xes     4567"
// * <p>
// * case 5：输入："      1234     "
// */
//class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String st = in.next();
////        String st = " ";
//        StringBuffer sb = new StringBuffer();
//        st = st.trim();
//        if (st == null || st.length() == 0 || st == "") {
//            sb.append("0-0");
//            System.out.println(sb.toString());
//            return;
//        }
//        char[] list = st.toCharArray();
////        if ('9'<list[0]||list[0]<'0'){
////            sb.append("0-0");
////            System.out.println(sb.toString());
////        }
//        int lastIdx=list.length;
//        for (int i = 0; i < list.length; i++) {
//            if ('9' < list[i] || list[i] < '0') {
//                lastIdx = i;
//            }
//        }
//        for (int i = 0; i <lastIdx ; i++) {
//            if ('9' < list[i] || list[i] < '0') {
//                continue;
//            }else {
//                sb.append(list[i]);
//                if ((i<=list.length-2)&&('9' < list[i] || list[i] < '0')){
//                    break;
//                }
//            }
//        }
//        String tmpF = sb.toString();
//        if (tmpF.length()==0){
//            System.out.println("0-0");
//            return;
//        }
//        System.out.println("1-"+tmpF);
//    }
//
//
//}
