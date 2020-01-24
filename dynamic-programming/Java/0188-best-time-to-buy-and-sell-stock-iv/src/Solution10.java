import java.util.Arrays;

public class Solution10 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k == 0) {
            return 0;
        }
        if (k >= len / 2) {
            // 贪心算法
            int res = 0;
            for (int i = 0; i < len - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    res += prices[i + 1] - prices[i];
                }
            }
            return res;
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, -9999);

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        return sell[k];
    }
}
