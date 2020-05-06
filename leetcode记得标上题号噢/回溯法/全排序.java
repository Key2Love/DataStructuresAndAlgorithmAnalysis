package 回溯法;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @author: Sunbuhui7
 * @create: 2020-05-04 21:12
 **/

class 全排序 {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    public void backtrack(int[] nums, LinkedList<Integer> track) {
        //
        if (track.size()==nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track);
            track.removeLast();
        }
    }
}
