import java.util.Arrays;

public class Solution4 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k == 0) {
            return 0;
        }
        if (k >= len / 2) {
            return greedy(prices, len);
        }

        // k 次持股分别的状态
        int[] stock = new int[k];
        Arrays.fill(stock, Integer.MIN_VALUE);
        // k 次不持股（持有现金）分别的状态
        int[] cash = new int[k];

        for (int price : prices) {
            for (int j = 0; j < k; j++) {
                stock[j] = Math.max(stock[j], (j == 0 ? 0 : cash[j - 1]) - price);
                cash[j] = Math.max(cash[j], stock[j] + price);
            }
        }
        return cash[k - 1];
    }

    private int greedy(int[] prices, int len) {
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}