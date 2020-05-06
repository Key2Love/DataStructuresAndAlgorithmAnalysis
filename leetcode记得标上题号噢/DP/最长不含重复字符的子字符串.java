package DP;

import java.util.HashMap;

/**
 * @program: Algorithm
 * @description: 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * @author: Sunbuhui7
 * @create: 2020-04-30 17:42
 **/

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, tmp = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int j = hm.containsKey(s.charAt(i))?hm.get(s.charAt(i)):-1;
            hm.put(s.charAt(i),i);
            tmp = tmp<(i-j)?tmp+1:i-j;
            res = Math.max(res,tmp);
        }
        return res;
    }

}
