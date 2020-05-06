package 二分法;

/**
 * @program: Algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-05-03 09:52
 **/

class SearchWord {
    //这里说的左右边界是不带target的
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;

        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;

        return right - left - 1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3};
        System.out.println(new SearchWord().search(a,3));
    }
}
