public class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int lastDay = days[len - 1];

        // 数组的作用是代替哈希表，以便后续快速检测是否当天有旅行
        int[] hashMap = new int[366];
        for (int day : days) {
            hashMap[day]++;
        }

        // dp[i]：到下标为 i 的这一天，旅行所需要的最低消费
        int[] dp = new int[lastDay + 1];
        for (int i = 1; i <= lastDay; i++) {
            if (hashMap[i] == 1) {
                dp[i] = min(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[lastDay];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}