package 双指针;

/**
 * @program: algorithm
 * @description: 给你 n 个非负整数 a1，a2，...，an，
 * 每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @author: Sunbuhui7
 * @create: 2020-04-18 22:25
 **/

public class MaxArea {
    /**
     * 双指针方法。
     * 只有那个最小值的指针才向内移动。why?
     * 如果是最大值向内移动，那么只可能边的最后计算的时候取<=最小值的。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = (height[i] < height[j]) ?
                    //如果[j++]写在前面，那么先进行j++操作，再进行max操作
                    //Math.max(res, height[i++]*(j - i))
                    //Math.max(res, height[j--]*(j - i))
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(a));
    }

}
