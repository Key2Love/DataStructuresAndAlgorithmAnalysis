package 剑指Offer;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-22 10:51
 **/

public class Solution1 {
        public int sumFourDivisors(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                int nowInt = nums[i];
                int[] yinshu = new int[3];
                for (int j = 2; j < nowInt / 2; j++) {
                    if (nowInt % j == 0&&j!=yinshu[1]) {
                        if(yinshu[0]!=0){
                            yinshu[2] =1;
                            break;
                        }
                        if (j==nowInt/j){
                            yinshu[2]=1;
                            break;
                        }else{
                            yinshu[0] = j;
                            yinshu[1] = nowInt / j;
                        }

                    }
                }
                if (yinshu[0]!=0&&yinshu[2]==0){
                    sum += yinshu[0]+yinshu[1]+nowInt+1;
                }

            }
            return sum;
        }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(new Solution1().sumFourDivisors(a));
    }
}
