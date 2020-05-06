package 分治法;

import java.lang.reflect.Array;

/**
 * @program: Algorithm
 * @description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * @author: Sunbuhui7
 * @create: 2020-05-03 10:41
 **/

class ReversePairs {
//    public int reversePairs(int[] nums) {
//
//    }

    /**
     * 这个归并排序模板还是很重要的
     * @param nums
     * @param start
     * @param end
     */
    public void merge(int[] nums,int start,int end){
        if (start==end) return;
        int mid = (start+end)/2;
        merge(nums,start,mid);
        merge(nums,mid+1,end);
        //申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
        int[] temp = new int[end-start+1];
        int i = start,j = mid+1,k=0;
        while(i<=mid&&j<=end){
            temp[k++] = nums[i]<nums[j]?nums[i++]:nums[j++];
        }
        while (i<=mid){
            temp[k++] = nums[i++];
        }
        while (j<=end){
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp,0,nums,start,end-start+1);

    }
}
