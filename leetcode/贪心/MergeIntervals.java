package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: algorithm
 * @description: 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @author: Sunbuhui7
 * @create: 2020-04-16 18:12
 **/

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0){
            return null;
        }
        int len = intervals.length;
        //这是最后的结果数组
        int[][] res = new int[len][2];
        //按照区间的起始位置排序。这一部分需要注意compartor的函数式写法
        //(v1,v2)->(v1[0]-v2[0])
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        //遍历区间
        int index = -1;
        for (int[] interval:intervals){
            if (index==-1||interval[0]>res[index][1]){
                //++x是先自增，再计算。
                res[++index] = interval;
            }else {
                res[index][1]  = Math.max(res[index][1],interval[1]);
            }
        }
        //为什么要有最后一步copy。因为初始化了原始大小的数组，合并之后没有那么多，在数组的尾部全是初始化的0
        return Arrays.copyOf(res,index+1);

    }

    public static void main(String[] args) {
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        int[][] b = new MergeIntervals().merge(a);
        System.out.println();
    }
}
