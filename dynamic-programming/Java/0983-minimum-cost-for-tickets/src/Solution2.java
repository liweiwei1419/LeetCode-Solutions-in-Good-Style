public class Solution2 {

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int maxDay = days[len - 1];
        int minDay = days[0];

        int[] dp = new int[maxDay + 31];
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
            if (d == days[i]) {
                dp[d] = min(dp[d + 1] + costs[0], dp[d + 7] + costs[1],dp[d + 30] + costs[2]);
                i--; // 别忘了递减一天
            } else {
                dp[d] = dp[d + 1];
            }
        }

        // 从后向前遍历，返回最前的 minDay
        // [0, 6, 4, 4, 4, 4, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,..]
        return dp[minDay];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {7, 2, 15};
//        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
//        int[] costs = {2, 7, 15};
        Solution2 solution2 = new Solution2();
        int res = solution2.mincostTickets(days, costs);
        System.out.println(res);
    }
}
