package 奇怪的方法;

/**
 * @program: Algorithm
 * @description:数组中有一个数字出现的次数超过数组长度的一半， 请找出这个数字。
 * @author: Sunbuhui7
 * @create: 2020-05-06 22:45
 **/

class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
