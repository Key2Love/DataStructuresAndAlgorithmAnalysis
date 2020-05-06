package 二分法;

/**
 * @program: Algorithm
 * @description: 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * @author: Sunbuhui7
 * @create: 2020-05-03 09:31
 **/

class MissingNumber {
    //一个tips，排好序的数组最好用二分法，双指针也会用到。
    //其实想二分没啥好想的，不过基础的算法要熟记。
    public int missingNumber(int[] nums) {
        int i = 0,j =nums.length-1;
        while (i<=j){
            int mid = (i+j)/2;
            if (nums[mid]==mid) i=mid+1;
            else {
                j = mid-1;
            }
        }
        return i;
    }

}
