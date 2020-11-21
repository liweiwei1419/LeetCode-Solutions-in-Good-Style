import java.util.Arrays;

public class Solution3 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k == 0) {
            return 0;
        }
        if (k >= len / 2) {
            return greedy(prices, len);
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        return sell[k];
    }

    private int greedy(int[] prices, int len) {
        // 贪心算法
        int res = 0;
        for (int i = 1; i < len; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}