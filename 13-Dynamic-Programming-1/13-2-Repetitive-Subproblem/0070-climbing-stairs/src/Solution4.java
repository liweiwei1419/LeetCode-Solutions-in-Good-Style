import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution4 {

    public List<List<Integer>> climbStairsBacktracking(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, path, res);
        return res;
    }

    private void dfs(int n, Deque<Integer> path, List<List<Integer>> res) {
        if (n == -1) {
            return;
        }
        if (n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= 2; i++) {
            path.addLast(i);
            dfs(n - i, path, res);
            path.removeLast();
        }
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        // 初值设置很重要
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();

        int n = 5;
        List<List<Integer>> res = solution4.climbStairsBacktracking(n);
        System.out.println(res);
        System.out.println(res.size());
        int dpRes = solution4.climbStairs(n);
        System.out.println(dpRes);
    }
}