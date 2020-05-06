package 数组;

import java.util.Arrays;

/**
 * @program: Algorithm
 * @description: 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
 * @author: Sunbuhui7
 * @create: 2020-05-02 16:56
 **/

public class PockerIsStraight {
    public boolean isStraight(int[] nums) {
        if (nums==null||nums.length!=5){
            return false;
        }
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i <4 ; i++) {
            if (nums[i]==0){
                joker++;
            }else if (nums[i]==nums[i+1]){
                return false;
            }
        }
        return nums[4]-nums[joker]<=4;
    }
}
