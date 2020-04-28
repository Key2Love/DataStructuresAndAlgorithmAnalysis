package 二分法;

/**
 * @program: Algorithm
 * @description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * @author: Sunbuhui7
 * @create: 2020-04-26 20:08
 **/

class FindMedianSortedArrays4 {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(a, 0, b, 0, left) + findKth(a, 0, b, 0, right)) / 2;
    }

    public double findKth(int[] a, int startA, int[] b, int startB, int k) {
        //当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了
        //相当于一个空数组了，那么实际上就变成了在另一个数组中找数字，直接就可以找出来了。
        if (startA>=a.length){
            return b[startB+k-1];
        }
        if (startB>=b.length){
            return a[startA+k-1];
        }
        //为什么把1挑出来，是因为k/2-1不可能为负
        if (k==1){
            return Math.min(a[startA],b[startB]);
        }
        //当超过了就没有比较的价值
        //赋予最大值的意思只是说如果第一个数组的K/2不存在，则说明这个数组的长度小于K/2，
        // 那么另外一个数组的前K/2个我们是肯定不要的。
        // 举个例子，加入第一个数组长度是2，第二个数组长度是12，
        // 则K为7，K/2为3，因为第一个数组长度小于3，
        // 则无法判断中位数是否在其中，而第二个数组的前3个肯定不是中位数！
        // 故当K/2不存在时，将其置为整数型最大值，这样就可以继续下一次循环。
        int midVal1 = (startA + k / 2 - 1 < a.length) ? a[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (startB + k / 2 - 1 < b.length) ? b[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(a, startA + k / 2, b, startB , k - k / 2);
        }else{
            return findKth(a, startA, b, startB + k / 2 , k - k / 2);
        }
        //细节非常多，记得常看。
    }

}




