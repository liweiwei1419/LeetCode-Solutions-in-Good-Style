/**
 * @author liweiwei1419
 * @date 2019/10/23 6:21 下午
 */
public class Solution5 {

    // 贪心算法

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int curMinVal = prices[0];
        int res = 0;
        for (int i = 0; i < len-1; i++) {
            if (prices[i + 1] >= prices[i]) {
                continue;
            } else {
                res += Math.max(0, prices[i] - curMinVal - fee);
                curMinVal = prices[i + 1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] prices = new int[]{1, 3, 2, 8, 4, 9,-1};
        int fee = 2;
        int res = solution5.maxProfit(prices, fee);
        System.out.println(res);
    }
}
