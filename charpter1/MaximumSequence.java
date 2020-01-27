//求序列的最大值

class MaximumSequence {
    public static int maxSubSum4 (int[] a){
        int maxSum =0, thisSum =0;
        for (int j = 0;j < a.length;j++){
            thisSum += a[j];
            if (thisSum > maxSum){
                maxSum = thisSum;
            }else if (thisSum < 0){
                thisSum = 0;
            }
        
            
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4-2,-1,10,12,4};
        int s = maxSubSum4(a);
        System.out.print(s);
        
    }
}