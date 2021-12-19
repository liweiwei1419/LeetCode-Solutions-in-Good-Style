public class Solution4 {

    // 方法三：记忆化递归

    private int[] dp;
    private int cnt = 0;
    private String res;

    public String getPermutation(int n, int k) {
        calculate(n);
        cnt = k;
        boolean[] memo = new boolean[n + 1];
        dfs(n, 0, "", memo);
        return res;
    }

    public void dfs(int n, int index, String s, boolean[] memo) {
        if (index == n) {
            if (res == null) {
                res = s;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (memo[i]) {
                continue;
            }
            if (dp[n - index - 1] < cnt) {
                cnt -= dp[n - index - 1];
                continue;
            }
            memo[i] = true;
            dfs(n, index + 1, s + i, memo);
            memo[i] = false;
        }
    }

    public void calculate(int n) {
        dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }
    }
}