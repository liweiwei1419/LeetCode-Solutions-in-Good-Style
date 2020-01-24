public class Solution2 {

    // 对暴力方法的优化：我们只关心之前（不包括现在）看到的最低股价
    // 时间复杂度：O(N)

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;

        // 表示在当前位置之前的最小值，假设修正法（打擂台法）
        int minVal = prices[0];
        // 注意：这里从 1 开始
        for (int i = 1; i < len; i++) {
            res = Math.max(res, prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }
        return res;
    }
}
