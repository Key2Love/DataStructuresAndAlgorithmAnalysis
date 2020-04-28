import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-24 20:18
 **/

public class DNA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String DNA1 = sc.nextLine();
        //String DNA2 = sc.nextLine();
        String DNA1 = "ATTTAAA";
        String DNA2 = "TTAATTT";
        char[] list1 = DNA1.toCharArray();
        char[] list2 = DNA2.toCharArray();
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        int need = 0;
        for (int i = 0; i < list1.length; i++) {
            char a = list1[i];
            char b = list2[i];
            if(a!=b){
                need++;
            }
            if (a == 'A') {
                nums1[0]++;
            } else {
                nums1[1]++;
            }
            if (b == 'A') {
                nums2[0]++;
            } else {
                nums2[1]++;
            }
        }

        int count = Math.max(nums1[0] - nums2[0], nums2[0] - nums1[0]);
        need = need - count;
        count += need/2;
        System.out.println(count);


    }
}
