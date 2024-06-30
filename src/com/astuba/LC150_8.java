package com.astuba;

/**
 * 买卖股票的最佳时机Ⅱ
 *
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class LC150_8 {

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,5,2,4,6,4,8};
        System.out.println(maxProfit(prices));
    }

    /**
     * 贪心算法：只要第i天比第i-1天大，就累加
     * 例如：13524648，由于5-1 = (3-1)+(5-3),所以对于持续上涨的股票，无须等待1涨到5才卖出，而是1涨到3卖出，再买入3，3涨到5再卖出
     * 这样最大的收益就是：（3-1）+（5-3）+（4-2）+（6-4）+（8-4）=12
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] > prices[i-1])
            {
                profit = profit + prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
