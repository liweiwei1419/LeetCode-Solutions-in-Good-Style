/**
 * @author liweiwei1419
 * @date 2019/10/29 7:19 下午
 */
public class Solution10 {

    // （1）初值很重要；
    // （2）状态的定义具有前缀含义
    // 参考资料：https://blog.csdn.net/qq_17550379/article/details/83620892

    // 状态转移方程：
    // buy1 = max(buy1, -prices[i])
    // sell1 = max(sell1, buy1 + prices[i])
    // buy2 = max(buy2, sell1 - prices[i])
    // sell2 = max(sell2, buy2 + prices[i])

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        // buy2 的初值设置很重要，不能设置为 0
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int i = 0; i < len; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        // 注意：因为具有前缀信息，一路都是 max 过来的额，所以返回 sell2 即可
        return sell2;

    }


    // 状态机

    public int maxProfit2(int[] prices) {
        // 不论是买和买，都先假设一个最坏的情况
        // 买的时候，最坏我只买不卖，钱会越来越少
        int buy1 = Integer.MIN_VALUE;
        // 卖的时候，因为求最大值，我最差什么情况就是不交易，收益为 0
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, price + buy1);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, price + buy2);
        }
        return sell2;
    }
}
