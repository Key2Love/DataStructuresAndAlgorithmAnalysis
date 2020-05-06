package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: Algorithm
 * @description: 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * @author: Sunbuhui7
 * @create: 2020-05-02 17:49
 **/
class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty()&&deque.peekLast()<nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i <nums.length ; i++) {
            if (deque.peekFirst()==nums[i-k]) deque.removeFirst();
            while (!deque.isEmpty()&&deque.peekLast()<nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            res[i-k+1]=deque.peekFirst();
        }
        return res;

    }
}
