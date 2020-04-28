package 二分法; /**
 * @program: Algorithm
 * @description: If you have any questions, feel free to reach out to me for the homework.
 * Given two integer array sorted by asc order, find the median of both array.
 * 1. Both space and time complexity <= O(m+n), m and n repsresent the size of two arrays
 * 2. Please implement it without library like python built-in sort, C++ STL etc.
 * 3. Provide unit test is a big plus
 * For example,  Input [1, 2, 3] and [4, 5], output 3.0
 * Input [2, 4] and [1, 7], output 2 + 4 / 2 = 3.0
 * @author: Sunbuhui7
 * @create: 2020-04-26 16:41
 **/

import org.junit.Test;

public class AppAnnie {

    public double findMedian(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 nums1
        //可以少写一个判断
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        //nums1空了，返回nums2[start2 + k - 1]
        if (len1 == 0) return nums2[start2 + k - 1];
        //如果要找的是第一个
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        //取出第k/2个
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        //当第一个数组里第k/2个大于第二个数据里的，说明第二个数组里前k/2个小于中位数，去除。
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            //同理
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }



    //测试用例如下
    @Test
    public void testEmpty() {
        int[] array1 = new int[0];
        int[] array2 = {1};
        AppAnnie app = new AppAnnie();
        //空，1
        System.out.println(app.findMedian(array1, array2));
        //1，空
        System.out.println(app.findMedian(array2, array1));
        //空空
        //System.out.println(app.findMedian(array1, array1));
    }

    @Test
    public void test1() {
        int[] array2 = {1};
        int[] array3 = {1, 2};
        AppAnnie app = new AppAnnie();
        //1,1
        System.out.println(app.findMedian(array2, array2));
        //1，2
        System.out.println(app.findMedian(array2, array3));
        //2，1
        System.out.println(app.findMedian(array3, array2));
        //2，2
        System.out.println(app.findMedian(array2, array2));
    }

    @Test
    public void test22() {
        int[] array4 = {1, 2, 5, 6, 8, 10};
        int[] array5 = {2, 5, 7, 8, 8, 11};
        //单个个数为偶数，总个数和为偶数。奇对奇，且有重复的
        AppAnnie app = new AppAnnie();
        System.out.println(app.findMedian(array4, array5));
    }

    @Test
    public void test2() {
        int[] array4 = {1, 2, 2, 3, 4};
        int[] array5 = {2, 5, 7, 8, 8};
        //单个个数和为奇数，总个数和为偶数。奇对奇，且有重复的
        AppAnnie app = new AppAnnie();
        System.out.println(app.findMedian(array4, array5));
    }

    @Test
    public void test3() {
        int[] array4 = {1, 2, 2, 3, 4};
        int[] array5 = {2, 5, 7, 8};
        //奇对偶，且有重复的
        AppAnnie app = new AppAnnie();
        System.out.println(app.findMedian(array4, array5));
    }

    @Test
    public void test4() {
        int[] array4 = {3, 4, 5, 9, 10, 12};
        int[] array5 = {2, 5, 7, 8, 8};
        //偶对奇，且有重复的
        AppAnnie app = new AppAnnie();
        System.out.println(app.findMedian(array4, array5));
    }
    @Test
    public void test5() {
        int[] array4 = {1, 2, 3, 4, 5};
        int[] array5 = {2, 5, 7, 8, 9,10};
        //奇对偶数，无重复
        AppAnnie app = new AppAnnie();
        System.out.println(app.findMedian(array4, array5));
    }
    @Test
    public void test6() {
        int[] array9 = {2, 5, 7, 8, 9,10};
        int[] array10 = {1, 2, 3, 4, 5};
        //偶对奇数，无重复
        AppAnnie app = new AppAnnie();
        System.out.println(app.findMedian(array9, array10));
    }


}
