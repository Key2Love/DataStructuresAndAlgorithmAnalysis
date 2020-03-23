package 剑指Offer;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-22 10:38
 **/

import java.util.*;
class Solution {
    public int[] createTargetArray1(int[] nums, int[] index) {
        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            tm.put(index[i],nums[i]);
        }
        int finalLen = tm.size();
        int[] finalArray = new int[finalLen];
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : tm.entrySet()){
            finalArray[count] = entry.getValue();
            count++;
        }
        return finalArray;

    }
        public int[] createTargetArray(int[] nums, int[] index) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int len = nums.length;
            for (int i = 0; i <len ; i++) {
                arrayList.add(index[i],nums[i]);
            }
            int finalLen = arrayList.size();
            int[] finalList = new int[finalLen];
            for (int i = 0; i <finalLen ; i++) {
                finalList[i] = arrayList.get(i);
            }
            return finalList;
        }
}
