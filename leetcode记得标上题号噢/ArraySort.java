import java.lang.reflect.Array;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-31 09:53
 **/

class ArraySort {
    public static void main(String[] args) {
        int[] a = {-1,2,-8,-10};
        a = new ArraySort().sortArray(a);
        for (int it : a) {
            System.out.println(it);
        }
    }

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void swapReference(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static int median3(int[] nums, int left, int right) {
        int center = (left + right) / 2;
        if (nums[left] > nums[right]) {
            swapReference(nums, left, right);
        }
        if (nums[left] > nums[center]) {
            swapReference(nums, left, center);
        }
        if (nums[center] > nums[right]) {
            swapReference(nums, center, right);
        }
        swapReference(nums, center, right - 1);
        return nums[right - 1];
    }

    private static void quicksort(int[] nums, int left, int right) {
        if (right - left > 2) {
            int pivot = median3(nums, left, right);
            //begin partitioning
            int i = left, j = right - 1;
            // 死循环的写法for ( ; ; )
            for (; ; ) {
                while (nums[++i] < nums[pivot]) {
                }
                while (nums[--j] > nums[pivot]) {
                }
                if (i < j) {
                    swapReference(nums, i, j);
                } else {
                    break;
                }
            }
            swapReference(nums, i, right - 1);
            quicksort(nums, left, i - 1);
            quicksort(nums, i + 1, right);
        } else {
            int len = right - left + 1;
            for (int i = 1; i < len; i++) {
                for (int j = left; j <=right-i ; j++) {
                    if (nums[j]>nums[j+1]){
                        swapReference(nums,j,j+1);
                    }
                }
            }
        }

    }

}
