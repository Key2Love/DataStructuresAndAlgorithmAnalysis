package 剑指Offer;

/**
 * @program: algorithm
 * @description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: Sunbuhui7
 * @create: 2020-03-16 10:09
 **/

public class TwoDimenArrayFind {
    public static void main(String[] args) {
        int intA[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new TwoDimenArrayFind().Find2(7,intA));

    }

    /**
     * 时间复杂度O(n*2),暴力解法
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find1(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据性质，一次查找可以删掉一整行.
     * @param target
     * @param array
     * @return
     */
    public boolean Find2(int target, int[][] array)  {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int i = array.length - 1;
        int colLen = array[0].length - 1;
        int j = 0;
        while(i>=0&&j<=colLen){
            int temp = array[i][j];
            if(temp>target){
                i--;
            }else if(temp<target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
