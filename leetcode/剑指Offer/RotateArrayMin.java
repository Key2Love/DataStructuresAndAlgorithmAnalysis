package 剑指Offer;

/**
 * @program: algorithm
 * @description: 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author: Sunbuhui7
 * @create: 2020-03-18 10:05
 **/

public class RotateArrayMin {
    public static void main(String[] args) {
        int[] a ={1,3,3};
        System.out.println(new RotateArrayMin().minNumberInRotateArray1(a));

    }

    /**
     * 最初的版本，没用考虑用例{1，3，3}，不过这个用例似乎不会存在。但是还是需要修改。
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int [] array) {
        if(array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        int len= array.length;
        int mid = (len-1)/2;
        int min = array[mid];
        if(array[mid]<array[len-1]){
            for(int i=mid;i>=1;i--){
                if(array[i-1]<=array[i]){
                    min = array[i-1];
                }else{
                    break;
                }
            }
        }else{
            for(int i=mid;i<len-1;i++){
                if(array[i+1]<=array[i]){
                    min = array[i+1];
                }else{
                    break;
                }
            }
        }
        return min;
    }
}
