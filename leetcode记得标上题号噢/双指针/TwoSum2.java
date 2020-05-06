package 双指针;

/**
 * @program: Algorithm
 * @description: 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * @author: Sunbuhui7
 * @create: 2020-05-02 20:05
 **/

public class TwoSum2 {
    //重点是这个排序，不然直接hashmap
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        //主要还是排序这两个字关键，而且大数组找小数组基本就要想到双指针。连续的话就是滑动窗口。
        while(i<j){
            int s = nums[i]+nums[j];
            if (s<target) i++;
            else if(s>target) j--;
            else return new int[]{i,j};
        }
        return new int[]{i,j};
    }
}
