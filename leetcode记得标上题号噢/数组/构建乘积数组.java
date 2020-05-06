package 数组;

/**
 * @program: Algorithm
 * @description: 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]
 * ，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * @author: Sunbuhui7
 * @create: 2020-05-02 11:01
 **/

class constructChengjiArr {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] B = new int[len];
        int pre = 1;
        for (int i = 0; i < len; i++) {
            B[i] = pre;
            pre *= a[i];
        }
        pre = 1;
        for (int i = len - 1; i >= 0; i--) {
            B[i] *= pre;
            pre *= a[i];
        }
        return B;
    }
}
