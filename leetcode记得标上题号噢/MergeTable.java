import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @program: algorithm
 * @description: 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * @author: Sunbuhui7
 * @create: 2020-03-13 14:49
 **/

public class MergeTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = Integer.parseInt(in.nextLine());
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            String str = in.nextLine();
            String[] strList = str.split(" ");
            int k = Integer.parseInt(strList[0]);
            int v = Integer.parseInt(strList[1]);
            if (!(tm.containsKey(k))) {
                tm.put(k, v);
            } else {
                tm.put(k, tm.get(k) + v);
            }
        }
        //Set<Map.Entry<int,int>> map = tm.entrySet();
        for (Map.Entry me : tm.entrySet()) {
            //t.append(me.getKey() + ": " + me.getValue() + "/n");
            System.out.println(me.getKey() + " " + me.getValue());
        }
        /**
         for (Integer key : map.keySet()) {
         System.out.println(key + " " + map.get(key));
         }
         */

    }
}
