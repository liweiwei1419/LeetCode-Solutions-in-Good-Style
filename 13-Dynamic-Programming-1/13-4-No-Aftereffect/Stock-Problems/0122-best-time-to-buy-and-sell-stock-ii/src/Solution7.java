public class Solution7 {

    // 方法三：贪心算法
    // 参考资料：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/ti-hao-122mei-you-shou-xu-fei-jia-yi-dian-dong-xi-/

    public int maxProfit(int[] prices) {
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
            } else if (prices[i] > curLowest) {
                // 否则就是非递减，减去 fee 表示还能赚钱
                res += (prices[i] - curLowest);
                // 此扣掉手续费的峰当作新谷
                curLowest = prices[i];
            }
        }
        return res;
    }
}