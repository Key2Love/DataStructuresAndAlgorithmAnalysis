package DP;

/**
 * @program: Algorithm
 * @description: 输入一个整型数组，数组里有正数也有负数。
 * 数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * @author: Sunbuhui7
 * @create: 2020-05-07 00:04
 **/

public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int pre = nums[0];
        int now ;
        for (int i = 1; i <nums.length ; i++) {
            now = Math.max(pre+nums[i],nums[i]);
            max = Math.max(now,max);
            pre = now;
        }
        return max;
    }
}
