package 排序;

import java.util.Arrays;

/**
 * @program: Algorithm
 * @description: 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * @author: Sunbuhui7
 * @create: 2020-05-06 23:30
 **/

public class 最小的K的个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr==null||arr.length==0){
            return new int[0];
        }
        findMinK(arr,0,arr.length-1,k-1);
        return Arrays.copyOfRange(arr,0,k);
    }

    public void findMinK(int[] nums,int left,int right,int k){
        if (left>=right) return ;
        int pivot = nums[left];
        int i = left,j = right;
        while (i<j){
            while (j>i&&nums[j]>=pivot){
                j--;
            }
            nums[i] = nums[j];
            while (j>i&&nums[i]<=pivot){
                i++;
            }
            nums[j] = nums[i];
//            if (i>=j){
//                break;
//            }
        }
        nums[i] = pivot;
        //这一块原本写的有点错误，其实它都是要找这个，不用k-i啊啥的
        if (i>k){
             findMinK(nums,left,i-1,k);
        }else if (i<k){
             findMinK(nums,i+1,right,k);
        }
        findMinK(nums,left,i-1,k);
    }
}
