package 数组;

/**
 * @program: Algorithm
 * @description: 找出数组中重复的数字。   在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Sunbuhui7
 * @create: 2020-05-02 09:45
 **/

 class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        int res = 0;
        for (int i = 0; i <len ; i++) {
            while (nums[i]!=i){
                if (nums[i]==nums[nums[i]]){
                    res = nums[i];
                    return res;
                }
                swap(nums,i,nums[i]);
            }
        }
        return res;
    }
    public void swap(int[] array,int a,int b){
//        int temp =array[a];
//        array[a] = array[b];
//        array[b] = temp;
        //第二种,使用异或，可以记得复习一下。
        array[a] = array[a]^array[b];
        array[b] = array[a]^array[b];
        array[a] = array[a]^array[b];
    }
}
