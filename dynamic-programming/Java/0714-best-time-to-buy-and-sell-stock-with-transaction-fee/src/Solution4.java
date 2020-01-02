/**
 * @author liweiwei1419
 * @date 2019/10/23 6:21 下午
 */
public class Solution4 {

    // 参考资料：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/ti-hao-122mei-you-shou-xu-fei-jia-yi-dian-dong-xi-/
    // 贪心算法

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        // 记录着低谷，curLowest
        int curLowest = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] < curLowest) {
                curLowest = prices[i];
            } else if (prices[i] - fee > curLowest) {
                // 否则就是非递减，减去 fee 表示还能赚钱
                res += (prices[i] - fee - curLowest);
                // 此扣掉手续费的峰当作新谷
                curLowest = prices[i] - fee;
            }
        }
        return res;
    }

}
