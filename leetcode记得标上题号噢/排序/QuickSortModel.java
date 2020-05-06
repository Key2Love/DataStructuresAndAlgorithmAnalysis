package 排序;

/**
 * @program: Algorithm
 * @description: 快排模板
 * @author: Sunbuhui7
 * @create: 2020-05-03 22:18
 **/

public class QuickSortModel {
//    public void sort(int[] nums, int start, int end) {
//        if (start>=end) return;
//        int pivot =median3(nums,start,end);
//        int i = start, j = end - 1;
//        for (; ; ) {
//            while (nums[++i] < pivot) {
//            }
//            ;
//            while (nums[--j] > pivot) {
//            }
//            ;
//
//            if (i < j) {
//                swap(nums, i, j);
//            } else {
//                break;
//            }
//        }
//        //        swap(nums,mid,end);
////        这个地方原本swap写错了，要记住快排的每一遍是把大于pivot的放在右边，小于的放在左边
//        swap(nums,i,end-1);
//        sort(nums, start, i-1);
//        sort(nums, i + 1, end);
//
//    }

//    public void sort(int[] nums, int start, int end) {
//        if (start>=end) return;;
//        int pivot = nums[start];
//        int i = start;
//        int j = end;
//        while (i<j){
//            while (i<j&&nums[j]>pivot){
//                j--;
//            }
//            while (i<j&&nums[i]<=pivot){
//                i++;
//            }
//            swap(nums,i,j);
//            j--;
//        }
//        sort(nums,start,i-1);
//        sort(nums,i+1,end);
//    }

    //快速排序
    void quick_sort(int s[], int left, int right)
    {
        if (left < right)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = left, j = right, pivot = s[left];
            while (i < j)
            {
                while(i < j && s[j] >= pivot){
                    j--;// 从右向左找第一个小于x的数
                }
                //注意这块
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] <= pivot){
                    i++;// 从左向右找第一个大于等于x的数
                }
                //注意这块
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = pivot;
            quick_sort(s, left, i - 1); // 递归调用
            quick_sort(s, i + 1, right);
        }
    }


    public void swap(int[] nums, int i, int j) {
//        nums[i] = nums[i] ^ nums[j];
//        nums[j] = nums[i] ^ nums[j];
//        nums[i] = nums[i] ^ nums[j];
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private int median3(int[] nums,int left,int right){
        if (nums[left]>nums[(left+right)/2]){
            swap(nums,left,(left+right)/2);
        }
        if (nums[left]>nums[right]){
            swap(nums,left,right);
        }
        if (nums[(left+right)/2]>nums[right]){
            swap(nums,(left+right)/2,right);
        }
        swap(nums,(left+right)/2,right-1);
        return nums[right-1];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 1, 6, 2,54,123,412,12124,1};
        new QuickSortModel().quick_sort(a, 0, a.length - 1);
        for (int in:
             a) {
            System.out.println(in);
        }
    }
}
