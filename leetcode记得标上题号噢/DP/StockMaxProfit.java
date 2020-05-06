package DP;

/**
 * @program: Algorithm
 * @description: 假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 * @author: Sunbuhui7
 * @create: 2020-05-02 11:40
 **/

class StockMaxProfit {
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0){
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for(int idx:prices){
            min = Math.min(min,idx);
            res = Math.max(res,idx-min);
        }
        return res;
    }
}
