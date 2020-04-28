package 位运算;

/**
 * @program: Algorithm
 * @description: 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @author: Sunbuhui7
 * @create: 2020-04-28 09:53
 **/

public class NumsInArray {
    public int[] singleNumbers(int[] nums) {
        int tempXorRes = 0;
        for (int num : nums) {
            tempXorRes ^= num;
        }
        //lowbit，返回从右往左第一个1。异或只有不相同该位才是1，所以那两个不相同的数字可以在这里区分开
        //a & (-a)返回返回从右往左第一个1。
        int flag = tempXorRes & (-tempXorRes);
        int[] res = new int[2];
        for (int num : nums) {
            //这里是原先做错的地方，这块是&运算。为了区分0和1
            if ((flag&num)==0){
                   res[0] ^= num;
            }else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
