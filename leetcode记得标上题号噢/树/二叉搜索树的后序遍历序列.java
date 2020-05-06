package 树;

/**
 * @program: Algorithm
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @author: Sunbuhui7
 * @create: 2020-05-04 16:41
 **/

class VerifyPostorder {
    /**
     * 这个后序遍历有点意思，左子树、右子树、根节点
     * 左子树<根节点，右子树<根节点。
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder==null||postorder.length<=1){
            return true;
        }
        return recur(postorder,0,postorder.length-1);
    }
    public boolean recur(int[] nums,int left,int right){
        if (left>=right) return true;
        int i = left;
        while (nums[i]<nums[right]) i++;
        int t = i;
        while (nums[t]>nums[right]) t++;
        return t==right&&recur(nums,left,i-1)&&recur(nums,i,right-1);
    }
}
