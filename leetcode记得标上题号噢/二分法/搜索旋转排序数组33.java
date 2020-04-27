package 二分法;

/**
 * @program: Algorithm
 * @description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。  你的算法时间复杂度必须是 O(log n) 级别。
 * @author: Sunbuhui7
 * @create: 2020-04-27 11:45
 **/

import org.junit.Test;


class SearchinRotatedSortedArray {
    public static final SearchinRotatedSortedArray temp = new SearchinRotatedSortedArray();

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        return find(nums, target, 0, len - 1);
    }

    public int find(int[] nums, int target, int start, int end) {
        //此处必不能clean code
        int mid = (start+end)/2;
        if (nums[mid]==target){
            return mid;
        }
//        if (nums[start]==target){
//            return start;
//        }
//        上面这一块可以省略，因为最后剩下两个值的时候mid就=第一个数，已经进行计算过。
//        或者可以这段还留着，下面的>=省略
        if (end-start<=1){
            return nums[end]==target?end:-1;
        }
        if (nums[start]<nums[mid]){
            if (target>=nums[start]&&target<nums[mid]){
                return find(nums,target,start,mid-1);
            }else {
                return find(nums,target,mid+1,end);
            }
        }else {
            if (target>nums[mid]&&target<=nums[end]){
                return find(nums,target,mid+1,end);
            }else {
                return find(nums,target,start,mid-1);
            }
        }

    }


    @Test
    public void test1() {
        int[] a = {1};
        System.out.println(temp.search(a, 1));
    }

    @Test
    public void test2() {
        int[] a = {1, 3};
        System.out.println(temp.search(a, 1));
    }

    @Test
    public void test3() {
        int[] a = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(temp.search(a, 8));
    }

    @Test
    public void test4() {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(temp.search(a, 0));
    }

    @Test
    public void test5() {
        int[] a = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(temp.search(a, 3));
    }
}
