public class Solution8 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int pre = prices[1] - prices[0];
        // 还是要考虑到 [7 , 6, 5, 4, 3] 这种不交易的情况
        // 初值应该考虑 0
        int res = Math.max(0, pre);
        int diff;
        int cur;

        for (int i = 1; i < len - 1; i++) {
            diff = prices[i + 1] - prices[i];
            cur = Math.max(diff, pre + diff);
            res = Math.max(res, cur);
            pre = cur;
        }
        return res;
    }
}
