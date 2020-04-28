package 位运算;

/**
 * @program: Algorithm
 * @description: 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 * （除了某个元素只出现一次以外，其余每个元素均出现两次。）这个是这题的重点。
 * @author: Sunbuhui7
 * @create: 2020-04-28 09:27
 **/

class SingleNumber {
    /**
     * 异或解法：异或运算满足交换律，a^b^a=a^a^b=b,
     * 因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4].....
     * 然后再根据交换律把相等的合并到一块儿进行异或（结果为0），
     * 然后再与只出现过一次的元素进行异或，这样最后的结果就是，
     * 只出现过一次的元素（0^任意值=任意值）
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len==0){
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i <len ; i++) {
            //异或 xor 两个值不相同为1，相同为0。异或具有结合律，0异或x返回x本身。
            res = res^nums[i];
        }
        return res;
    }
}
