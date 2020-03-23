import java.util.*;

/**
 *
 * @author shw76
 */
public class CalculationStringOccurrences {
    public static void main(String[] args){
        String[] st = "sd".split(" ");
        int a = st.length;
        Scanner in = new Scanner(System.in);
        String strs = in.nextLine();
        in.hasNextInt();
        Integer.parseInt("d");
        String str = in.nextLine();
        TreeSet<Integer> integers = new TreeSet<>();

        if(strs==""){
            System.out.println(0);
        }else if(str==""){
            System.out.println(0);
        }else {
            int len = strs.length();
            int count = 0;
            for(int i=0;i<len;i++){

                if(String.valueOf(strs.charAt(i)).equalsIgnoreCase(str)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
