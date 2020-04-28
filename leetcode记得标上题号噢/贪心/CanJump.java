package 贪心;

/**
 * @program: algorithm
 * @description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * @author: Sunbuhui7
 * @create: 2020-04-17 10:20
 **/

public class CanJump {
    /**
     * 贪心算法只关注能不能的问题，不关心最优解。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        //判断边界值。判空，判0
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        //max用于定义全局能到达的最大位置。
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i]+i);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canJumpDP(int[] nums) {
        //判断边界值。判空，判0
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        boolean[] canVisit = new boolean[len];
        canVisit[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                canVisit[i] = canVisit[j] && nums[j] + j >= i;
                if (canVisit[i]) {break;}
            }
        }
        return canVisit[len - 1];
    }

    public static void main(String[] args) {
        int[] a = {2, 0,0};
        System.out.println(new CanJump().canJumpDP(a));
    }
}
