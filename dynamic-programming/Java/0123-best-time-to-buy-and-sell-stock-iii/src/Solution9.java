/**
 * @author liweiwei1419
 * @date 2019/10/29 4:04 下午
 */
public class Solution9 {

    // 参考资料：https://www.cnblogs.com/grandyang/p/4281975.html

    // 思想：在差分数组上思考状态转移方程（状态压缩）

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 第 1 维表示天数
        // 第 2 维表示 0，1，2：最多交易几次
        int[] global = new int[3];
        int[] local = new int[3];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 2; j > 0; j--) {
                // 顺序不能交换，因为先有局部，再有全局
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }

}
