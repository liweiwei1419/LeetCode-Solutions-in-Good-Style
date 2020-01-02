/**
 * @author liweiwei1419
 * @date 2019/10/29 4:04 下午
 */
public class Solution8 {

    // 参考资料：https://www.cnblogs.com/grandyang/p/4281975.html
    // https://blog.csdn.net/linhuanmars/article/details/23236995

    // 思想：在差分数组上思考状态转移方程

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 第 1 维表示天数
        // 第 2 维表示 0，1，2：最多交易几次
        int[][] global = new int[len][3];
        int[][] local = new int[len][3];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; j++) {
                // 顺序不能交换，因为先有局部，再有全局
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        return global[len - 1][2];
    }

}
